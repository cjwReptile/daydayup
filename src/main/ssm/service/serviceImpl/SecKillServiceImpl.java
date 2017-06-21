package ssm.service.serviceImpl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.Exceptions.RepeatSecKillException;
import ssm.Exceptions.SecKillCloseException;
import ssm.Exceptions.SecKillException;
import ssm.dao.SecKillDao;
import ssm.dao.SuccessKillDao;
import ssm.dto.Exproser;
import ssm.dto.SecKillExcution;
import ssm.enums.SecKIllEnum;
import ssm.model.SecKill;
import ssm.model.SuccessKill;
import ssm.service.SecKillService;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by cjw on 2017/6/21.
 */
@Service
public class SecKillServiceImpl implements SecKillService{
    @Autowired
    private SecKillDao secKillDao;
    @Autowired
    private SuccessKillDao successKillDao;

    private String slat="ASH8D9H29RHQ0WNF9P3H9-2U-13R01H39-B9SN0182HRH";
    /**
     *获取单个秒杀记录
     */
    public SecKill queryById(Long secKillid) {

        SecKill secKill=secKillDao.queryById(secKillid);
        return secKill;
    }
    /**
     *获取秒杀商品列表
     */
    public List<SecKill> queryAll(int offset, int limit) {
        List<SecKill> secKills=secKillDao.queryAll(0,4);
        return secKills;
    }
    /**
     *暴露秒杀接口地址
     */
    public Exproser getSecKillUrl(Long seckillId) {
        SecKill secKill=secKillDao.queryById(seckillId);

        if (secKill==null){
             return new Exproser(seckillId,false);
        }
        Date startTime=secKill.getStartTime();
        Date endTime=secKill.getEndTime();
        Date now=new Date();
        if(now.getTime()< startTime.getTime() || now.getTime()>endTime.getTime()){
            //秒杀未开启，返回当前时间
             return new Exproser(seckillId,false,startTime,endTime,now);
        }
        String md5=getMD5(seckillId);
        //秒杀开启，返回接口
        return new Exproser(seckillId,md5,true);
    }
    /**
     *执行秒杀方法
     */
    @Transactional
    public SecKillExcution excuteSecKill(Long seckIllId, Long userPhone, String md5)
    throws RepeatSecKillException,SecKillCloseException,SecKillException
    {

       if(md5==null||!getMD5(seckIllId).equals(md5)){
          throw new SecKillException("seckill md5 change");
       }
       Date now=new Date();
       try {
           int i=successKillDao.insertSuccessKill(seckIllId,userPhone);
           //i<0重复秒杀
           if(i<0){
               throw new RepeatSecKillException("repeate seckill");
           }else{
               //执行减库存
               int j=secKillDao.updataProduct(seckIllId,now);
               if(j<0){
                   throw new SecKillCloseException("seckill close");
               }else{
                   //秒杀成功
                   SuccessKill successKill=successKillDao.querySuccessRecord(seckIllId,userPhone);
                   return new SecKillExcution(seckIllId, SecKIllEnum.SUCCESS,successKill);
               }
           }
       }catch (RepeatSecKillException e1){
            throw e1;
       }catch (SecKillCloseException e2){
            throw e2;
       }catch (Exception e3){
            throw new SecKillException("error"+ e3.getMessage());
       }
    }
    /**
     *获取md5值
     */
    public String getMD5(Long secKillId){
        String value=secKillId+"/"+slat;
        String md5;
        md5 = DigestUtils.md5Hex(value.getBytes());
        return md5;
    }
}
