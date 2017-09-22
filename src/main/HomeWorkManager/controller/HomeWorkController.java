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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
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
   public @ResponseBody Map<String,String> login(@RequestBody UserEnity userEnity){
       System.out.println(userEnity.getUserName());
       System.out.println(userEnity.getPassword());
       map.put("flag","1");
       if(userEnity.getUserName()==null||userEnity.getPassword()==null)
           map.put("flag","0");

       Subject subject= SecurityUtils.getSubject();
       UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userEnity.getUserName(),userEnity.getPassword());
       try {
           subject.login(usernamePasswordToken);
       }catch (UnknownAccountException e){
           map.put("msg","账号不存在或者密码错误");
           map.put("flag","0");
       }catch (ExcessiveAttemptsException e){
           map.put("msg","登录次数过多");
           map.put("flag","0");
       }catch (IncorrectCredentialsException e){
           map.put("msg","密码错误");
           map.put("flag","0");
       }
       return map;
   }

   @RequestMapping(value="/image")
    public @ResponseBody Map<String,String > imageUpload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request){
       System.out.println(file.getSize()+"name");
       return null;
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
