package HomeWorkManager.dao;

import HomeWorkManager.enity.UserEnity;
import org.springframework.stereotype.Repository;

/**
 * Created by cjw on 2017/9/5.
 */
@Repository
public interface UserDao {
    public UserEnity findUserByName(String userName);
}
