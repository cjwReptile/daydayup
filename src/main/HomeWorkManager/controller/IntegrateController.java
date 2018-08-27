package HomeWorkManager.controller;

import HomeWorkManager.dto.IntegrateInfoDto;
import HomeWorkManager.dto.IntegrateScoreDto;
import HomeWorkManager.enity.Integrate.DayDayUpBo;
import HomeWorkManager.enity.Integrate.IntegratePlateParent;
import HomeWorkManager.enity.Integrate.IntegratePlateSon;
import HomeWorkManager.enity.Integrate.ReturnEntity;
import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.enums.StateEnum;
import HomeWorkManager.service.IntegrateService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("/integrate")
public class IntegrateController {
    private org.slf4j.Logger logger=  LoggerFactory.getLogger(IntegrateController.class);

    @Autowired
    IntegrateService integrateService;

    @RequestMapping(value = "/plateParent",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> insertPlateParent( IntegratePlateParent params){
        Map<String,Object> map=new HashMap<>();
        try {
            integrateService.insertIntoParentPlate(params);
            map.put("flag",StateEnum.SUCCESS.getValue());
        }catch (Exception e){
            logger.error(e.getMessage());
            map.put("flag",StateEnum.FAILED.getValue());
        }
        return map;
    }

    @RequestMapping(value = "/plateParent",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getPlateParent( UserEnity userEnity){
        Map<String,Object> map=new HashMap<>();
        List<IntegrateInfoDto> list=integrateService.getPlateParent(userEnity);
        map.put("flag",StateEnum.SUCCESS.getValue());
        map.put("message","获取板块成功");
        map.put("data",list);
        return map;
    }

    @RequestMapping(value = "/plateParent",method = RequestMethod.PUT)
    public @ResponseBody Map<String,Object> updatePlateParent ( String id, String plateName){
        Map<String,Object> map=new HashMap<>();
        try {
            if(!StringUtils.isEmpty(id)){
                integrateService.updatePlateParent(Integer.parseInt(id),plateName);
            }

        }catch (Exception e){
            e.printStackTrace();
            map=result(StateEnum.FAILED.getValue(),"更新失败");
            return map;
        }
        map=result(StateEnum.SUCCESS.getValue(),"更新成功");
        return map;
    }

    @RequestMapping(value = "/plateParent",method = RequestMethod.DELETE)
    public @ResponseBody Map<String,Object> deletePlateParent(@RequestBody String id){
        Map<String,Object> map=new HashMap<>();
        try {
            if(!StringUtils.isEmpty(id)){
                integrateService.deletePlateParent(Integer.parseInt(id));
            }else {
                map.put("flag",StateEnum.FAILED.getValue());
                return map;
            }
        }catch (Exception e){
            logger.error("错误",e);
            map.put("flag",StateEnum.FAILED.getValue());
            return map;
        }
        map.put("flag",StateEnum.SUCCESS.getValue());
        map.put("message","删除成功");
        return map;
    }

    @RequestMapping(value = "/score",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getScoreInfo(IntegrateScoreDto dto){
        Map<String,Object> map=new HashMap<>();
        try {
            List<Map<String, Object>> result =  integrateService.getScoreInfo(dto);
            map.put("data",result);
        }catch (Exception e){
            logger.error("错误",e);
            map.put("flag",StateEnum.FAILED.getValue());
            return map;
        }
        map.put("flag",StateEnum.SUCCESS.getValue());
        map.put("message","删除成功");
        return map;
    }

    @RequestMapping(value = "/score",method = RequestMethod.PUT)
    public @ResponseBody ReturnEntity saveScoreInfo(DayDayUpBo bo){
        ReturnEntity returnEntity=null;
        if(null == bo || null==bo.getDataMap() || bo.getTeaBelong() == null || StringUtils.isEmpty(bo.getTime())){
            returnEntity=new ReturnEntity(1,"参数不能为空");
            return returnEntity;
        }
        try {
            integrateService.saveScoreInfo(bo);
        }catch (Exception e){
            logger.error("错误",e);
            returnEntity=ReturnEntity.FAIL;
            return returnEntity;
        }
        return returnEntity;
    }

    @RequestMapping(value="/plateSon",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> insertPlateSon(IntegratePlateSon integratePlateSon){
        try {
            integrateService.insertIntoSonPlate(integratePlateSon);
        }catch (Exception e){
            logger.error("plateSon put",e);
            return  result(false,"插入子版块失败");
        }

        return  result(true,"插入子版块成功");
    }

    @RequestMapping(value="/plateSon",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getPlateSon(Integer parentId){
        Map<String,Object> map = new HashMap<>();
        List<IntegrateInfoDto> data = null;
        try {
           data = integrateService.getPlateSon(parentId);
        }catch (Exception e){
            logger.error("plateSon put",e);

            return result(false,"获取子版块成功");
        }
        return  result(true,"获取子版块成功","data",data);
    }

    @RequestMapping(value="/plateSon",method = RequestMethod.DELETE)
    public @ResponseBody Map<String,Object> deletePlateSon(@RequestBody String id){
        try {
            integrateService.deletePlateSon(Integer.parseInt(id));
        }catch (Exception e){
            logger.error("plateSon put",e);

            return result(false,"删除子版块失败");
        }
        return  result(true,"删除子版块成功");
    }

    @RequestMapping(value="/plateSon",method = RequestMethod.PUT)
    public @ResponseBody Map<String,Object> updatePlateSon(String id, String plateName){
        try {
            integrateService.updatePlateSon(Integer.parseInt(id),plateName);
        }catch (Exception e){
            logger.error("plateSon put",e);

            return result(false,"更新子版块失败");
        }
        return  result(true,"更新子版块成功");
    }




    public Map<String,Object> result(boolean flag,String message,Object...data){
        Map<String,Object> map=new HashMap<>();
        map.put("flag",flag);
        map.put("message",message);
        if(data != null && data.length>0){
            if(data.length%2==0){
                for (int i=0;i<data.length;i+=2){
                     map.put((String)data[i],data[i+1]);

                }
            }

        }
        return map;
    }
}
