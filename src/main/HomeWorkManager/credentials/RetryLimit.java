package HomeWorkManager.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cjw on 2017/9/7.
 */
public class RetryLimit extends HashedCredentialsMatcher {

        public Cache<String,AtomicInteger> passWordCache;

        public RetryLimit(CacheManager cacheManager){
            passWordCache=cacheManager.getCache("passwordRetryCache");
        }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
           String userName=(String)token.getPrincipal();
           System.out.println(userName+"limit");
           AtomicInteger atomicInteger=passWordCache.get(userName);

           if(atomicInteger==null){
               atomicInteger=new AtomicInteger(0);
               passWordCache.put(userName,atomicInteger);
           }
           if(atomicInteger.incrementAndGet()>5){
               throw new ExcessiveAttemptsException();
           }
           boolean flag=super.doCredentialsMatch(token,info);
           if(flag){
              passWordCache.remove(userName);
               return true;
           }

           return true;
    }
}
