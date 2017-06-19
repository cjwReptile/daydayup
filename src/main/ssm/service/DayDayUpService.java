package ssm.service;

import ssm.model.SecKillBo;
import ssm.model.UserBean;

import java.util.List;
import java.util.Map;

/**
 * Created by hasee on 2017/4/27.
 */
public interface DayDayUpService {
    public UserBean findUserForLogin(String key);

    public List<UserBean> findUser(Integer pageSize,Integer page);

    public boolean login(UserBean userBean);

    public Map<String,Object> getGoodInfo(SecKillBo bo);

    public void updateGoodNum();

    public void addSuccessCount(SecKillBo bo);

    public boolean addUserToRedis(SecKillBo bo);

    public int getUserSetSize(SecKillBo bo);
}
