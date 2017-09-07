package HomeWorkManager.service.serviceImpl;

import HomeWorkManager.dao.UserDao;
import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.UserService;
import HomeWorkManager.utils.PassWordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by cjw on 2017/9/5.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public UserEnity findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }

    public void createUser(UserEnity userEnity) {
        PassWordUtil.encryptPassword(userEnity);
        userDao.createUser(userEnity);
    }

    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    public void updateUser(UserEnity userEnity) {
        userDao.updateUser(userEnity);
    }

    public void relateUserAndRole(Long userId, Long... roleIds) {
        if(roleIds==null||roleIds.length==0)
            return;
        for (Long roleId:roleIds){
            userDao.relateUserAndRole(userId,roleId);
        }
    }

    public void unrelateUserAndRole(Long userId, Long... roleIds) {
        if(roleIds==null||roleIds.length==0)
            return;
        for (Long roleId:roleIds){
            userDao.unrelateUserAndRole(userId,roleId);
        }
    }

    public Set<String> findRoles(String userName) {
        return userDao.findRoles(userName);
    }

    public Set<String> findPermissions(String userName) {
        return userDao.findPermissions(userName);
    }
}
