package HomeWorkManager.controller;

import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cjw on 2017/9/5.
 */
@Controller
@RequestMapping("/homework")
public class HomeWorkController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(UserEnity userEnity, Model model){
           System.out.println(userEnity.getUserName()+"sssssssssssssssssssssssssssssssssssssssss");
           String result=doLogin(userEnity);
           if(!"SUCC".equals(result)){

           }
        if (!"SUCC".equals(result)) {
            model.addAttribute("failMsg", "用户不存在或密码错误！");
            return "/homeworkjsp/fail";
        }else{
            model.addAttribute("successMsg", "登陆成功！");//返回到页面说夹带的参数
            model.addAttribute("name", userEnity.getUserName());
            return "/homeworkjsp/success";//返回的页面
        }
    }

    public String doLogin(UserEnity userEnity){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userEnity.getUserName(),userEnity.getPassword());
        try {
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException e){
             return "用户不存在";
        }catch (IncorrectCredentialsException e){
             return "密码不正确";
        }catch (Exception e){
             e.printStackTrace();
             return "系统错误";
        }
        return "SUCC";
    }
}
