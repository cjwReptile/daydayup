package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.interceptor.MethodCacheInterceptor;

/**
 * Created by hasee on 2017/4/27.
 */
@Controller
@RequestMapping(value="/cjw")
public class DayDayUpController {
    @RequestMapping(value="/test")
       public void test(){
            System.out.print("sssssss");
           MethodCacheInterceptor methodCacheInterceptor=new MethodCacheInterceptor();
           methodCacheInterceptor.set();
       }

}
