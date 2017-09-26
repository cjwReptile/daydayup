package HomeWorkManager.controller;

import HomeWorkManager.enity.HomeWorkPo;
import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.HomeWorkService;
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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by cjw on 2017/9/5.
 */
@Controller
@RequestMapping("/homework")
public class HomeWorkController {
    @Autowired
    private UserService userService;
    @Autowired
    private HomeWorkService homeWorkService;

    private Map<String,String> map=new HashMap<String, String>();

   @RequestMapping(value="/login",method = RequestMethod.POST)
   public @ResponseBody Map<String,String> login(@RequestBody UserEnity userEnity){
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
           return map;
       }catch (ExcessiveAttemptsException e){
           map.put("msg","登录次数过多");
           map.put("flag","0");
           return map;
       }catch (IncorrectCredentialsException e){
           map.put("msg","密码错误");
           map.put("flag","0");
           return map;
       }
       map.put("username",(String)subject.getPrincipal());
       return map;
   }

   @RequestMapping(value="/image")
    public @ResponseBody Map<String,String > imageUpload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response){
       ServletContext sc=request.getSession().getServletContext();
       String fileName=UUID.randomUUID()+file.getOriginalFilename();
       map.put("flag","1");
       String startPath="http://localhost:8080/daydayup/";
       String endPath="statics/image/uploadImage/";
       String path=sc.getRealPath("/")+endPath;//存储到项目的路径
       String projectPath=startPath+endPath+fileName;//存储到数据库的url，前端能访问
       path=path.replaceAll("\\\\","/");
       File f=new File(path);
       FileOutputStream fos=null;
       InputStream in=null;
       if(!f.exists()){
           f.mkdirs();
       }
       try {
           fos=new FileOutputStream(path+fileName);
           in=file.getInputStream();
           int b=0;
           while((b=in.read())!=-1){
                fos.write(b);
           }
           fos.close();
           in.close();
       }catch (Exception e){
           response.setStatus(500);
       }

       return map;
   }

    @RequestMapping(value="/imageTest")
    public @ResponseBody Map<String,String > imageUploadTest(@RequestParam("file")CommonsMultipartFile[] file, HttpServletRequest request, HttpServletResponse response,@RequestParam String contentId){
        ServletContext sc=request.getSession().getServletContext();
        System.out.println(contentId);
        for(int i=0;i<file.length;i++){
            String fileName=UUID.randomUUID()+file[i].getOriginalFilename();
            map.put("flag","1");
            String startPath="http://localhost:8080/daydayup/";
            String endPath="statics/image/uploadImage/";
            String path=sc.getRealPath("/")+endPath;//存储到项目的路径
            String projectPath=startPath+endPath+fileName;//存储到数据库的url，前端能访问
            path=path.replaceAll("\\\\","/");
            File f=new File(path);
            FileOutputStream fos=null;
            InputStream in=null;
            if(!f.exists()){
                f.mkdirs();
            }
            try {
                fos=new FileOutputStream(path+fileName);
                in=file[i].getInputStream();
                int b=0;
                while((b=in.read())!=-1){
                    fos.write(b);
                }
                fos.close();
                in.close();
            }catch (Exception e){
                response.setStatus(500);
            }
        }


        return map;
    }

    @RequestMapping(value = "/homeWorkContent",method = RequestMethod.POST)
    public void saveHomeWorkInfo(@RequestBody HomeWorkPo homeWorkPo){
        homeWorkService.saveHomeWorkInfo(homeWorkPo);
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
