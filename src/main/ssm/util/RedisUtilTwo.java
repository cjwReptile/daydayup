package ssm.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

/**
 * Created by cjw on 2017/6/19.
 */
public class RedisUtilTwo {
    private static JedisPool jedisPool;

    public synchronized static Jedis getConnection(){
        try{
            Jedis jedis=jedisPool.getResource();
            return jedis;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static void returnResouce(final Jedis jedis){
        if(jedis!=null){
            jedisPool.returnResourceObject(jedis);
        }
    }

    public static void set(String key,String value){
        Jedis jedis=getConnection();
        if(jedis!=null){
            jedis.set(key,value);
        }
    }

    public static void sadd(String key,String value){
        Jedis jedis=getConnection();
        if(jedis!=null){
            jedis.sadd(key,value);
        }
    }

    public static Set<String> smembers(String key){
        Jedis jedis=getConnection();
        Set<String> set=null;
        if(jedis!=null){
            set=jedis.smembers(key);
            return set;
        }
        return set;
    }

    public  static Object get(String key){
        Jedis jedis=getConnection();
        if(jedis!=null){
            return jedis.get(key);
        }
        return null;
    }



    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
        return null;
    }

    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }



}
