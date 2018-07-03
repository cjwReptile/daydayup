package HomeWorkManager.service.serviceImpl;

import HomeWorkManager.dao.IntegrateDao;
import HomeWorkManager.dto.IntegrateInfoDto;
import HomeWorkManager.enity.Integrate.IntegratePlateParent;
import HomeWorkManager.enity.Integrate.IntegratePlateScore;
import HomeWorkManager.enity.Integrate.IntegratePlateSon;
import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.IntegrateService;
import HomeWorkManager.utils.CollectionUtil;
import HomeWorkManager.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                dto.setUpdateTimeStr(DateUtil.formatDate("yyyy-MM-dd",dto.getUpdateTime()));
                List<IntegratePlateSon> son=getPlateSonForInner(dto.getId());
                dto.setList(son);
            }
            return list;
        }
        return null;
    }

    @Override
    public void deletePlateParent(int id) {
         integrateDao.deletePlateParent(id);
    }

    @Override
    public void updatePlateParent(int id,String plateName) {
        integrateDao.updatePlateParent(id,plateName);
    }

    @Override
    public void insertIntoSonPlate(IntegratePlateSon integratePlateSon) {
        integrateDao.insertIntoSonPlate(integratePlateSon);
    }

    @Override
    public List<IntegrateInfoDto> getPlateSon(int id) {
        List<IntegratePlateSon> result = integrateDao.getPlateSon(id);
        List<IntegrateInfoDto> finalResult = new ArrayList<>();
        if(CollectionUtil.isNotEmpty(result)){
            for(IntegratePlateSon son : result){
                IntegrateInfoDto dto = new IntegrateInfoDto();
                dto.setUpdateTimeStr(DateUtil.formatDate("yyyy-MM-dd",son.getCreateTime()));
                dto.setId(son.getId());
                dto.setPlateName(son.getPlateName());
                dto.setParentId(son.getParentId());
                finalResult.add(dto);
            }
        }
        return finalResult;
    }

    public List<IntegratePlateSon> getPlateSonForInner(int id) {
        return integrateDao.getPlateSon(id);
    }

    @Override
    public List<Map<String, Object>> getScoreInfo(String teaBelong) {

        List<Map<String,Object>> resultMap = new ArrayList<>();
        List<IntegratePlateScore> list=integrateDao.getScoreInfo(teaBelong);
        String t_name = "";
        String id = "";
        String key= "";
        Map<String,Map<String,Object>> businessMap = new HashMap<>();
        if(CollectionUtil.isNotEmpty(list)){
            for (IntegratePlateScore enity : list){
                if(businessMap.get(enity.getStuBelong())==null){
                    Map<String,Object> mid = new HashMap<>();
                    t_name = enity.getStuBelong();
                    id = enity.getBelongPlate()+"";
                    mid.put(id,enity.getScore());
                    mid.put("name",t_name);
                    businessMap.put(enity.getStuBelong(),mid);
                }else {
                    id = enity.getBelongPlate()+"";
                    businessMap.get(enity.getStuBelong()).put(id,enity.getScore());
                }
            }
        }
        if(businessMap !=null){
            for(Map.Entry<String,Map<String,Object>> entry: businessMap.entrySet()){
                Map<String,Object> temp = entry.getValue();
                temp.put("name",entry.getKey());
                for(Map.Entry<String,Object> scoEntry : temp.entrySet()){
                    temp.put(scoEntry.getKey(),scoEntry.getValue());
                }
                resultMap.add(temp);
            }
        }
        return resultMap;
    }


    @Override
    public void deletePlateSon(int id){
        integrateDao.deletePlateSon(id);
    }

    @Override
    public void updatePlateSon(int id,String plateName){
        integrateDao.updatePlateSon(id,plateName);
    }


}
