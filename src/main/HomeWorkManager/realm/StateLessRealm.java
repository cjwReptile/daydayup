package HomeWorkManager.realm;

import HomeWorkManager.shiroAndToken.StateLessToken;
import HomeWorkManager.shiroAndToken.session.SessionManager;
import HomeWorkManager.utils.JwtUtils;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cjw on 2017/12/16.
 */
public class StateLessRealm extends AuthorizingRealm {

    @Autowired
    private SessionManager sessionManager2;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof StateLessToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        StateLessToken stateLessToken=(StateLessToken)token;
        String userName=stateLessToken.getClientKey();
        String tokenStr=stateLessToken.getToken();
        String serverToken= JwtUtils.encodeJwt(userName, SignatureAlgorithm.HS256);
        if(tokenStr==null||!sessionManager2.ValidateSession(userName,tokenStr)){
            System.out.println("aaaaaaaaaaaaaaaaa");
            throw new AuthenticationException("User " + userName + " authenticate fail in System");

        }

        System.out.println("sssssssssssssssssss");
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
                userName,tokenStr,getName());
        return authenticationInfo;
    }

    public void setSessionManager2(SessionManager sessionManager2) {
        this.sessionManager2 = sessionManager2;
    }
}
