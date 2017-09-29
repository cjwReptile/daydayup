package HomeWorkManager.dao;

import HomeWorkManager.dto.HomeWorkInfoDTO;
import HomeWorkManager.enity.HomeWorkLocationPo;
import HomeWorkManager.enity.HomeWorkPo;
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

    public List<HomeWorkInfoDTO> getHomeWorkInfo();

}
