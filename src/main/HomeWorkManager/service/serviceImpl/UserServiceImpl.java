package HomeWorkManager.service.serviceImpl;

import HomeWorkManager.dao.UserDao;
import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cjw on 2017/9/5.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public UserEnity findUserByName(String userName) {
           UserEnity userBean=null;
           UserEnity userBean1=userDao.findUserByName(userName);
           return userBean1;
    }
}
