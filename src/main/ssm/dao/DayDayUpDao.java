package ssm.dao;

import org.springframework.stereotype.Repository;
import ssm.model.UserBean;

import java.util.List;

/**
 * Created by hasee on 2017/4/27.
 */
@Repository
public interface DayDayUpDao {
      public UserBean findUserForLogin(String key);

      public List<UserBean>findUser();
}
