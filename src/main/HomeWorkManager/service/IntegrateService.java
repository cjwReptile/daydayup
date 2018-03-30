package HomeWorkManager.service;

import HomeWorkManager.dto.IntegrateInfoDto;
import HomeWorkManager.enity.Integrate.IntegratePlateParent;
import HomeWorkManager.enity.UserEnity;

import java.util.List;

public interface IntegrateService {

    public void insertIntoParentPlate(IntegratePlateParent integratePlateParent);

    public List<IntegrateInfoDto> getPlateParent(UserEnity userEnity);


}
