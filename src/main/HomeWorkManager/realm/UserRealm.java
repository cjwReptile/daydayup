package HomeWorkManager.realm;

import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

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
        String passWord=new String(((char[])token.getCredentials()));

        UserEnity userBean=userService.findUserByName(userName);
        if (userBean==null)
            throw new UnknownAccountException();
        if(!passWord.equals(userBean.getPassword())){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(userBean.getUserName(),userBean.getPassword(),"UserRealm");
    }
}
