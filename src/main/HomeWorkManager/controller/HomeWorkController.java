package HomeWorkManager.controller;

import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cjw on 2017/9/5.
 */
@Controller
@RequestMapping("/homework")
public class HomeWorkController {
    @Autowired
    private UserService userService;

    private Map<String,String> map=new HashMap<String, String>();

   @RequestMapping(value="/login",method = RequestMethod.POST)
   public ModelAndView login(UserEnity userEnity, Model model){
       System.out.println(userEnity.getUserName());
       System.out.println(userEnity.getPassword());
       String page="";
       if(userEnity.getUserName()==null||userEnity.getPassword()==null)
           page= "/homeworkjsp/fail";

       Subject subject= SecurityUtils.getSubject();
       UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userEnity.getUserName(),userEnity.getPassword());
       try {
           subject.login(usernamePasswordToken);
       }catch (UnknownAccountException e){
           map.put("failMsg","账号不存在或者密码错误");
           page= "/homeworkjsp/fail";
       }catch (ExcessiveAttemptsException e){
           map.put("failMsg","登录次数过多");
           page= "/homeworkjsp/login";
       }catch (IncorrectCredentialsException e){
           map.put("failMsg","密码错误");
           page= "/homeworkjsp/login";
       }
       return new ModelAndView(page,map);
   }
    @RequestMapping(value = "/createUser",method = RequestMethod.POST)
    public void createUser(UserEnity userEnity){
           userService.createUser(userEnity);
    }
    @RequestMapping(value = "/toCreateUser",method = RequestMethod.GET)
    public String toCreateUser(){
        return "/homeworkjsp/register";
    }
}
