package HomeWorkManager.realm;

import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by cjw on 2017/9/5.
 */
public class UserRealm extends AuthorizingRealm {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName=(String)token.getPrincipal();
        UserEnity userBean=userService.findUserByName(userName);
        if (userBean==null)
            throw new UnknownAccountException();

        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
             userBean.getUserName(),userBean.getPassword(), ByteSource.Util.bytes(userBean.getCredentialsSalt()),getName()
        );
         return authenticationInfo;
    }
}
