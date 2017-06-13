package ssm.service;

import ssm.model.UserBean;

import java.util.List;

/**
 * Created by hasee on 2017/4/27.
 */
public interface DayDayUpService {
    public UserBean findUserForLogin(String key);

    public List<UserBean> findUser(Integer pageSize,Integer page);
}
