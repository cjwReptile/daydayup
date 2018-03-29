package HomeWorkManager.service.serviceImpl;

import HomeWorkManager.dao.IntegrateDao;
import HomeWorkManager.enity.Integrate.IntegratePlateParent;
import HomeWorkManager.service.IntegrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrateServiceImpl implements IntegrateService{

    @Autowired
    IntegrateDao integrateDao;

    @Override
    public void insertIntoParentPlate(IntegratePlateParent integratePlateParent) {
        integrateDao.insertIntoParentPlate(integratePlateParent);
    }
}
