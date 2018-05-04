package HomeWorkManager.service.serviceImpl;

import HomeWorkManager.dao.IntegrateDao;
import HomeWorkManager.dto.IntegrateInfoDto;
import HomeWorkManager.enity.Integrate.IntegratePlateParent;
import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.IntegrateService;
import HomeWorkManager.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrateServiceImpl implements IntegrateService{

    @Autowired
    IntegrateDao integrateDao;

    @Override
    public void insertIntoParentPlate(IntegratePlateParent integratePlateParent) {
        integrateDao.insertIntoParentPlate(integratePlateParent);
    }

    @Override
    public List<IntegrateInfoDto> getPlateParent(UserEnity userEnity) {
        List<IntegrateInfoDto> list=integrateDao.getPlateParent(userEnity);
        if(CollectionUtil.isNotEmpty(list)){
            for(IntegrateInfoDto dto:list){

            }
        }
        return null;
    }
}
