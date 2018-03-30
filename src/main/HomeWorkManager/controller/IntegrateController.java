package HomeWorkManager.controller;

import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.IntegrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class IntegrateController {

    @Autowired
    IntegrateService integrateService;

    @RequestMapping(value = "/plateParent",method = RequestMethod.POST)
    public Map<String,String> insertPlateParent(){



        return null;
    }

    @RequestMapping(value = "/plateParent",method = RequestMethod.GET)
    public Map<String,String> getPlateParent(@RequestBody UserEnity userEnity){

        integrateService.getPlateParent(userEnity);


        return null;
    }

}
