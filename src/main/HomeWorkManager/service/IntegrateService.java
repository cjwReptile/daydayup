package HomeWorkManager.service;

import HomeWorkManager.dto.IntegrateInfoDto;
import HomeWorkManager.dto.IntegrateScoreDto;
import HomeWorkManager.enity.Integrate.DayDayUpBo;
import HomeWorkManager.enity.Integrate.IntegratePlateParent;
import HomeWorkManager.enity.Integrate.IntegratePlateSon;
import HomeWorkManager.enity.UserEnity;

import java.util.List;
import java.util.Map;

public interface IntegrateService {

    public void insertIntoParentPlate(IntegratePlateParent integratePlateParent);

    public List<IntegrateInfoDto> getPlateParent(UserEnity userEnity);

    public void deletePlateParent(int id);

    public void updatePlateParent(int id,String value);

    public void insertIntoSonPlate(IntegratePlateSon integratePlateSon);

    public List<IntegrateInfoDto> getPlateSon(int id);

    public void deletePlateSon (int id);

    public void updatePlateSon (int id,String plateName);

    public List<Map<String,Object>> getScoreInfo(IntegrateScoreDto dto);

    public boolean saveScoreInfo(DayDayUpBo bo);
}
