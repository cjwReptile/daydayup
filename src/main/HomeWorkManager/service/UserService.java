package HomeWorkManager.service;

import HomeWorkManager.enity.UserEnity;

import java.util.Set;

/**
 * Created by cjw on 2017/9/5.
 */
public interface UserService {

    public UserEnity findUserByName(String userName);

    public void createUser(UserEnity userEnity);

    public void deleteUser(Long userId);

    public void updateUser(UserEnity userEnity);

    public void relateUserAndRole(Long userId,Long...roleIds);

    public void unrelateUserAndRole(Long userId,Long...roleIds);

    Set<String> findRoles(String userName);

    Set<String> findPermissions(String userName);

}
