package test.controller;

import HomeWorkManager.enity.UserEnity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;

/**
 * Created by cjw on 2017/9/7.
 */
public class Test {

    public String login(UserEnity userEnity, Model model){
        if(userEnity.getUserName()==null||userEnity.getPassword()==null)
            return "/homeworkjsp/fail";

        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userEnity.getUserName(),userEnity.getPassword());
        try {
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException e){
            model.addAttribute("failMsg","账号不存在或者密码错误");
            return "/homeworkjsp/fail";
        }catch (ExcessiveAttemptsException e){
            model.addAttribute("failMsg","登录次数过多");
            return "/homeworkjsp/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("failMsg","密码错误");
            return "/homeworkjsp/login";
        }
        return null;
    }
}
