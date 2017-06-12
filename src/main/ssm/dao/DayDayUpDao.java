package ssm.dao;

import org.springframework.stereotype.Repository;
import ssm.model.UserBean;

/**
 * Created by hasee on 2017/4/27.
 */
@Repository
public interface DayDayUpDao {
      public UserBean findUserForLogin();
}
