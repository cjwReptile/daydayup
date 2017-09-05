package HomeWorkManager.service;

import HomeWorkManager.enity.UserEnity;

/**
 * Created by cjw on 2017/9/5.
 */
public interface UserService {
    public UserEnity findUserByName(String userName);
}
