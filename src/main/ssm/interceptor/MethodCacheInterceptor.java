package ssm.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import ssm.util.RedisUtil;

import java.util.List;

/**
 * Created by cjw on 2017/6/9.
 */
public class MethodCacheInterceptor implements MethodInterceptor{
    private RedisUtil redisUtil;
    private List<String> targetNamesList; // 禁用缓存的类名列表
    private List<String> methodNamesList; // 禁用缓存的方法列表
    private String defaultCacheExpireTime; // 缓存默认的过期时间


    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] keys=methodInvocation.getArguments();
        Object value=null;
        String targetName=methodInvocation.getThis().getClass().getName();
        String methodName=methodInvocation.getMethod().getName();
        if(!idAddCache(methodName,targetName)){
            return methodInvocation.proceed();
        }
        final String key=getCacheKey(methodName,targetName,keys);
        try {
            if(redisUtil.exsists(key)){
                return redisUtil.get(key);
            }
            value=methodInvocation.proceed();
            if(value!=null){
                final Object fvalue=value;
                new Thread(new Runnable() {
                    public void run() {
                        redisUtil.set(key,fvalue);
                    }
                }).start();
            }
        }catch (Exception e){
            if(value==null){
                return methodInvocation.proceed();
            }
            e.printStackTrace();
        }

        return value;
    }
    public boolean idAddCache(String methodName,String targetName){
        boolean flag=true;
        if(methodNamesList.contains(methodName)||targetNamesList.contains(targetName)){
                   flag=false;
        }
        return flag;
    }

    public String  getCacheKey(String methodName,String targetName,Object[] keys){
        StringBuffer sb=new StringBuffer();
        if(methodName!=null&&targetName!=null){
            sb.append(methodName).append("_").append(targetName);
        }
        if(keys!=null&&keys.length>0){
            for(int i=0;i<keys.length;i++){
                sb.append("_").append(keys[i]);
            }
        }

        return sb.toString();
    }



    public RedisUtil getRedisUtil() {
        return redisUtil;
    }

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    public List<String> getTargetNamesList() {
        return targetNamesList;
    }

    public void setTargetNamesList(List<String> targetNamesList) {
        this.targetNamesList = targetNamesList;
    }

    public List<String> getMethodNamesList() {
        return methodNamesList;
    }

    public void setMethodNamesList(List<String> methodNamesList) {
        this.methodNamesList = methodNamesList;
    }

    public String getDefaultCacheExpireTime() {
        return defaultCacheExpireTime;
    }

    public void setDefaultCacheExpireTime(String defaultCacheExpireTime) {
        this.defaultCacheExpireTime = defaultCacheExpireTime;
    }


}
