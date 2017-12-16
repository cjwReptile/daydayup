package HomeWorkManager.shiroAndToken.session;

import HomeWorkManager.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created by cjw on 2017/12/15.
 */
public class SessionManager {

    private PropertiesUtil propertiesUtil=new PropertiesUtil("/properties/daydayup.properties");


    @Autowired
    private RedisTemplate<Serializable,Object> redisTemplate;

    public void addToSession(String userName,String token){
        HashOperations<Serializable,String,String>operations=redisTemplate.opsForHash();
        operations.put(userName,token,getCur());
    }

    public boolean exsist(String userName,String token){

       // redisTemplate.hasKey(userName);
        HashOperations<Serializable,String,String>operations=redisTemplate.opsForHash();
        return operations.hasKey(userName,token);
    }

    public boolean ValidateSession(String userName,String token){

        if(!exsist(userName,token))return false;
        HashOperations<Serializable,String,String>operations=redisTemplate.opsForHash();
        int oldTime=Integer.parseInt(operations.get(userName,token));
        int timeout=getTimeout();
        int cur=Integer.parseInt(getCur());
        if(oldTime+timeout>cur){
            //超时
            redisTemplate.delete(userName);
            return false;
        }
        //更新过期时间
        operations.put(userName,token,getCur());
        redisTemplate.expire(userName,timeout,TimeUnit.MILLISECONDS);
        return true;
    }

    public int getTimeout(){
        int timeout= Integer.parseInt(propertiesUtil.getValue("timeout"))*60*1000;
        return timeout;
    }

    public boolean deleteSession(String userName){
        boolean flag=false;
        try {
            redisTemplate.delete(userName);
            flag=true;
        }catch (Exception e){

        }
         return flag;
    }

    public String getCur(){
        return String.valueOf(System.currentTimeMillis()/1000);
    }


    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
