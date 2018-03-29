package HomeWorkManager.controller;

import HomeWorkManager.service.IntegrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
