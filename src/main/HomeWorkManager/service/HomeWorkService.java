package HomeWorkManager.service;

import HomeWorkManager.dto.HomeWorkInfoDTO;
import HomeWorkManager.dto.StudentDto;
import HomeWorkManager.enity.HomeWorkCommentPo;
import HomeWorkManager.enity.HomeWorkLocationPo;
import HomeWorkManager.enity.HomeWorkPo;

import java.util.List;

/**
 * Created by cjw on 2017/9/26.
 */
public interface HomeWorkService {

    public void saveHomeWorkInfo(HomeWorkPo homeWorkPo);

    public Long getHomeWorkKey();

    public void saveContentLocationInfo(HomeWorkLocationPo homeWorkLocationPo);

    public List<HomeWorkInfoDTO> getHomeWorkInfo(String listType);

    public void saveHomeWorkComment(HomeWorkCommentPo homeWorkCommentPo);

    boolean  saveUserInfo(StudentDto dto);

}
