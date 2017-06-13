package ssm.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.DayDayUpDao;
import ssm.model.UserBean;
import ssm.service.DayDayUpService;

import java.util.List;

/**
 * Created by hasee on 2017/4/27.
 */
@Service
public class DayDayUpServiceImpl implements DayDayUpService{
    @Autowired
    private DayDayUpDao dayDayUpDao;


    public UserBean findUserForLogin(String key) {
        return dayDayUpDao.findUserForLogin(key);
    }

    public List<UserBean> findUser(Integer pageSize,Integer page) {
        System.out.print("进入了dao");
        return dayDayUpDao.findUser();
    }


}
