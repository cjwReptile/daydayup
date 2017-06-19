package ssm.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.DayDayUpDao;
import ssm.model.SecKillBo;
import ssm.model.UserBean;
import ssm.service.DayDayUpService;
import ssm.util.RedisUtilTwo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hasee on 2017/4/27.
 */
@Service
public class DayDayUpServiceImpl implements DayDayUpService{
    @Autowired
    private DayDayUpDao dayDayUpDao;



    public UserBean findUserForLogin(String key) {
        return dayDayUpDao.findUserForLogin(key);
    }

    public List<UserBean> findUser(Integer pageSize,Integer page) {
        System.out.print("进入了dao");
        return dayDayUpDao.findUser();
    }

    public boolean login(UserBean userBean) {
          UserBean user=null;
          if(userBean!=null){
               user=dayDayUpDao.login(userBean);
               if(user!=null){
                   return true;
               }
          }
          return false;
    }

    public Map<String, Object> getGoodInfo(SecKillBo bo) {
        Map<String,String> map = dayDayUpDao.getGoodInfo(bo);
        if(map!=null&&map.get("secKillCount")!=null){
             RedisUtilTwo.set(map.get("secKillId"),map.get("secKillCount"));
        }
        return null;
    }



    public void updateGoodNum() {

    }
    @Transactional
    public void addSuccessCount(SecKillBo bo) {
          dayDayUpDao.updateGoodNum(bo);
          dayDayUpDao.addSuccessCount(bo);
    }

    public boolean addUserToRedis(SecKillBo bo) {
         Set<String>set=null;
         if(bo.getParam().get("userId")!=null){
             set=RedisUtilTwo.smembers("userQueue");
             if(set==null||set.size()<=10){
                 RedisUtilTwo.sadd("userQueue",bo.getParam().get("userId"));
                 return true;
             }else{
                 return false;
             }
         }
         return false;
    }

    public int getUserSetSize(SecKillBo bo) {
            Set<String>set=null;
            set=RedisUtilTwo.smembers("userQueue");
            if(set==null){
                return 0;
            }
        return set.size();
    }


}
