package HomeWorkManager.dao;

import HomeWorkManager.dto.HomeWorkInfoDTO;
import HomeWorkManager.enity.HomeWorkCommentPo;
import HomeWorkManager.enity.HomeWorkLocationPo;
import HomeWorkManager.enity.HomeWorkPo;
import HomeWorkManager.enity.Integrate.IntegrateStuTea;
import HomeWorkManager.enity.Integrate.IntegrateStudent;
import HomeWorkManager.enity.UserEnity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cjw on 2017/9/26.
 */
@Repository
public interface HomeWorkDao {

    public void saveHomeWorkInfo(HomeWorkPo homeWorkPo);

    public Long getHomeWorkKey();

    public void saveContentLocationInfo(HomeWorkLocationPo homeWorkLocationPo);

    public List<HomeWorkInfoDTO> getHomeWorkInfo(String listType);

    public void saveHomeWorkComment(HomeWorkCommentPo homeWorkCommentPo);

    public void updateReaded(HomeWorkCommentPo homeWorkCommentPo);

    public void saveStudentInfo(IntegrateStudent student);

    public void saveStuAndTeaRelate(IntegrateStuTea integrateStuTea);


}
