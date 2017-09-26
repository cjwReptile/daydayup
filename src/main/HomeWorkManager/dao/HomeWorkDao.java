package HomeWorkManager.dao;

import HomeWorkManager.enity.HomeWorkPo;
import org.springframework.stereotype.Repository;

/**
 * Created by cjw on 2017/9/26.
 */
@Repository
public interface HomeWorkDao {

    public void saveHomeWorkInfo(HomeWorkPo homeWorkPo);

}
