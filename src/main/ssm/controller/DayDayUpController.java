package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.model.UserBean;
import ssm.service.DayDayUpService;

import java.util.List;

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
        System.out.println("asdadadsdada");
        System.out.println(service.findUserForLogin("test").getUserName());
    }

    @RequestMapping(value="/test1")
    public void findUser(){
        List<UserBean> list=service.findUser(Integer.valueOf(5),Integer.valueOf(4));
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getUserName()+"测试缓存看看");
        }
    }
}
