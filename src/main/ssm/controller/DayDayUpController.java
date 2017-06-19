package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.model.SecKillBo;
import ssm.model.UserBean;
import ssm.service.DayDayUpService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value="/seckill")
    public @ResponseBody Map<String,String> seckill(SecKillBo bo){
        Map<String,String> map=new HashMap<String, String>();
        int i=service.getUserSetSize(bo);
        if(i>10){
             map.put("success","0");
             return map;
        }else{
             if(service.addUserToRedis(bo)){
                 service.addSuccessCount(bo);
                 map.put("success","1");
             }

        }
        return map;
    }
}
