package HomeWorkManager.controller;

import HomeWorkManager.dto.IntegrateInfoDto;
import HomeWorkManager.enity.Integrate.IntegratePlateParent;
import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.enums.StateEnum;
import HomeWorkManager.service.IntegrateService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Map<String,Object> insertPlateParent(@RequestBody IntegratePlateParent params){
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
        map.put("data",list);
        return map;
    }

    @RequestMapping(value = "/plateParent",method = RequestMethod.PUT)
    public @ResponseBody Map<String,Object> updatePlateParent( UserEnity userEnity){
        Map<String,Object> map=new HashMap<>();
        List<IntegrateInfoDto> list=integrateService.getPlateParent(userEnity);
        map.put("flag",StateEnum.SUCCESS.getValue());
        map.put("data",list);
        return map;
    }

}
