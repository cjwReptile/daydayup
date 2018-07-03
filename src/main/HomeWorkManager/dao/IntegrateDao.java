package HomeWorkManager.dao;

import HomeWorkManager.dto.IntegrateInfoDto;
import HomeWorkManager.enity.Integrate.IntegratePlateParent;
import HomeWorkManager.enity.Integrate.IntegratePlateScore;
import HomeWorkManager.enity.Integrate.IntegratePlateSon;
import HomeWorkManager.enity.UserEnity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IntegrateDao {

    public void insertIntoParentPlate(IntegratePlateParent integratePlateParent);

    public List<IntegrateInfoDto> getPlateParent(UserEnity userEnity);

    public void deletePlateParent(int id);

    public void updatePlateParent(@Param("id")int id, @Param("plateName") String plateName);

    public void insertIntoSonPlate(IntegratePlateSon integratePlateSon);

    public List<IntegratePlateSon> getPlateSon (int id);

    public void deletePlateSon (int id);

    public void updatePlateSon (@Param("id")int id, @Param("plateName") String plateName);

    public List<IntegratePlateScore> getScoreInfo(String teaBelong);


}
