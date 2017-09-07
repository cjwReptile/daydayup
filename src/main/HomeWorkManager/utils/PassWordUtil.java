package HomeWorkManager.utils;

import HomeWorkManager.enity.UserEnity;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by cjw on 2017/9/7.
 */
public class PassWordUtil {

    private static RandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();

    private static  String algorithmName = "md5";

    private static int hashIterations = 2;


    public static void encryptPassword(UserEnity userEnity){
           if(userEnity==null)return;
           userEnity.setSalt(randomNumberGenerator.nextBytes().toHex());
           System.out.println(userEnity.getCredentialsSalt());
           String newPassWord=new SimpleHash(
                   algorithmName, userEnity.getPassword(),ByteSource.Util.bytes(userEnity.getCredentialsSalt()),hashIterations).toHex();
        userEnity.setPassword(newPassWord);
    }

}
