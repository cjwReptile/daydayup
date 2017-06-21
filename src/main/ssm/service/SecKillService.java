package ssm.service;

import ssm.Exceptions.RepeatSecKillException;
import ssm.Exceptions.SecKillCloseException;
import ssm.Exceptions.SecKillException;
import ssm.dto.Exproser;
import ssm.dto.SecKillExcution;
import ssm.model.SecKill;

import java.util.List;

/**
 * Created by cjw on 2017/6/21.
 */
public interface SecKillService {
    /**
     *@Author  cjw
     *@Date 2017/6/21 11:08
     *@Description 获取秒杀商品
     */
    SecKill queryById(Long secKillid);
    /**
     *@Author  cjw
     *@Date 2017/6/21 11:09
     *@Description 获取秒杀商品列表
     */
    List<SecKill> queryAll(int offset,int limit);
    /**
     *暴露秒杀地址
     */
    Exproser getSecKillUrl(Long seckillId);
    /**
     *秒杀方法
     */
    SecKillExcution excuteSecKill(Long seckIllId,Long userPhone,String md5)
    throws RepeatSecKillException,SecKillCloseException,SecKillException;
}
