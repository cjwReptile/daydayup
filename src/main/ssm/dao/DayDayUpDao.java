package ssm.dao;

import org.springframework.stereotype.Repository;
import ssm.model.SecKillBo;
import ssm.model.UserBean;

import java.util.List;
import java.util.Map;

/**
 * Created by hasee on 2017/4/27.
 */
@Repository
public interface DayDayUpDao {
      public UserBean findUserForLogin(String key);

      public List<UserBean>findUser();

      public UserBean login(UserBean userBean);

      public Map<String,String> getGoodInfo(SecKillBo bo);

      public void updateGoodNum(SecKillBo bo);

      public void addSuccessCount(SecKillBo bo);
}
