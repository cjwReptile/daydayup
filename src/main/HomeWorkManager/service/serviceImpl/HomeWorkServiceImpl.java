package HomeWorkManager.service.serviceImpl;

import HomeWorkManager.dao.HomeWorkDao;
import HomeWorkManager.enity.HomeWorkPo;
import HomeWorkManager.service.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cjw on 2017/9/26.
 */
@Service
public class HomeWorkServiceImpl implements HomeWorkService{
    @Autowired
    private HomeWorkDao homeWorkDao;
    //后期加上权限
    public void saveHomeWorkInfo(HomeWorkPo homeWorkPo){
        homeWorkDao.saveHomeWorkInfo(homeWorkPo);
    }
}
