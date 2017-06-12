package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.service.DayDayUpService;

/**
 * Created by hasee on 2017/4/27.
 */
@Controller
@RequestMapping(value="/cjw")
public class DayDayUpController {
    @Autowired
    private DayDayUpService service;

    @RequestMapping(value="/test")
    public void findUserForLogin(){
        System.out.println(service.findUserForLogin().getUserName());
    }
}
