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
        System.out.print("ssssssss");
        for(Object key:keys){
             if(redisUtil.exsists(key.toString())){
                  return redisUtil.get(key.toString());
             }
        }
        methodInvocation.proceed();
        return null;
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
