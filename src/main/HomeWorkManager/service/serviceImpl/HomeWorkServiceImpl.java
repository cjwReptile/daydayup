package HomeWorkManager.service.serviceImpl;

import HomeWorkManager.dao.HomeWorkDao;
import HomeWorkManager.dto.HomeWorkInfoDTO;
import HomeWorkManager.enity.HomeWorkCommentPo;
import HomeWorkManager.enity.HomeWorkLocationPo;
import HomeWorkManager.enity.HomeWorkPo;
import HomeWorkManager.service.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Long getHomeWorkKey() {
        return homeWorkDao.getHomeWorkKey();
    }

    public void saveContentLocationInfo(HomeWorkLocationPo homeWorkLocationPo) {
        homeWorkDao.saveContentLocationInfo(homeWorkLocationPo);
    }
    //作业列表
    public List<HomeWorkInfoDTO> getHomeWorkInfo(String listType) {
        return homeWorkDao.getHomeWorkInfo(listType);
    }

    @Transactional
    public void saveHomeWorkComment(HomeWorkCommentPo homeWorkCommentPo) {
        homeWorkDao.saveHomeWorkComment(homeWorkCommentPo);
        homeWorkDao.updateReaded(homeWorkCommentPo);
    }

}
