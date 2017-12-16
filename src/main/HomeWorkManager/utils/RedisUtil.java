package HomeWorkManager.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;

/**
 * Created by cjw on 2017/6/9.
 */
public class RedisUtil {
    private RedisTemplate<Serializable,Object> redisTemplate;

    public void remove(String[] keys){
        for (String key:keys){
            remove(key);
        }
    }

    public void remove(String key){
          if(exsists(key)){
              redisTemplate.delete(key);
          }
    }

    public boolean exsists(final  String key){
         return  redisTemplate.hasKey(key);
    }

    public Object get(String key){
        Object result=null;
        ValueOperations<Serializable,Object> operations=redisTemplate.opsForValue();
        result=operations.get(key);
        return result;
    }

    public boolean set(final  String key,Object value){
        boolean result=false;
        try{
            ValueOperations<Serializable,Object>operations=redisTemplate.opsForValue();
            operations.set(key,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


}
