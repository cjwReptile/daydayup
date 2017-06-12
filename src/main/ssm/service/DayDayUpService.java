package ssm.service;

import ssm.model.UserBean;

/**
 * Created by hasee on 2017/4/27.
 */
public interface DayDayUpService {
    public UserBean findUserForLogin(String key);
}
