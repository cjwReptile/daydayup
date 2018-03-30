package HomeWorkManager.controller;

import HomeWorkManager.dto.HomeWorkInfoDTO;
import HomeWorkManager.enity.HomeWorkCommentPo;
import HomeWorkManager.enity.HomeWorkLocationPo;
import HomeWorkManager.enity.HomeWorkPo;
import HomeWorkManager.enity.UserEnity;
import HomeWorkManager.service.HomeWorkService;
import HomeWorkManager.service.UserService;
import HomeWorkManager.shiroAndToken.session.SessionManager;
import HomeWorkManager.utils.JwtUtils;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
import java.util.List;
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



    @Autowired
    private SessionManager sessionManager2;



    private ThreadLocal<Map<String,String>> localSession=new ThreadLocal<>();

   @RequestMapping(value="/login",method = RequestMethod.POST)
   public @ResponseBody Map<String,String> login(@RequestBody UserEnity userEnity, HttpServletRequest request, HttpServletResponse response){
       HashMap<String,String> map=new HashMap<>();
       localSession.set(map);
       localSession.get().put("flag","1");
       localSession.get().put("flag","1");
       if(userEnity.getUserName()==null||userEnity.getPassword()==null)
           map.put("flag","0");

       String token=JwtUtils.encodeJwt(userEnity.getUserName(), SignatureAlgorithm.HS256);
       sessionManager2.addToSession(userEnity.getUserName(),token);
       localSession.get().put("loginTime",sessionManager2.getLoginTime(userEnity.getUserName(),token));
       localSession.get().put("username",userEnity.getUserName());
       localSession.get().put("roles",JSON.toJSONString(userService.findRoles(userEnity.getUserName())));
       localSession.get().put("token",token);
       return  localSession.get();
   }

   @RequestMapping(value="/workLocationInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,String > imageUpload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response,@RequestParam String contentId,@RequestParam String contentType){
       ServletContext sc=request.getSession().getServletContext();
       String fileName=UUID.randomUUID()+file.getOriginalFilename();
       localSession.get().put("flag","1");
       String startPath="http://localhost:8080/daydayup/";
       String endPath="statics/image/uploadImage/";

       HomeWorkLocationPo homeWorkLocationPo=new HomeWorkLocationPo();
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
       homeWorkLocationPo.setContentId(contentId);
       homeWorkLocationPo.setContentUrl(projectPath);
       homeWorkLocationPo.setContentType(contentType);
       homeWorkService.saveContentLocationInfo(homeWorkLocationPo);
       return localSession.get();
   }

    @RequestMapping(value="/imageTest")
    public @ResponseBody Map<String,String > imageUploadTest(@RequestParam("file")CommonsMultipartFile[] file, HttpServletRequest request, HttpServletResponse response,@RequestParam String contentId){
        ServletContext sc=request.getSession().getServletContext();
        System.out.println(contentId);
        for(int i=0;i<file.length;i++){
            String fileName=UUID.randomUUID()+file[i].getOriginalFilename();
            localSession.get().put("flag","1");
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


        return localSession.get();
    }

    @RequestMapping(value = "/homeWorkContent",method = RequestMethod.POST)
    public @ResponseBody Map<String,String> saveHomeWorkInfo(@RequestBody HomeWorkPo homeWorkPo){

        homeWorkService.saveHomeWorkInfo(homeWorkPo);
        localSession.get().put("flag","1");
        return localSession.get();
    }


    @RequestMapping(value = "/createUser",method = RequestMethod.POST)
    public void createUser(UserEnity userEnity){
           userService.createUser(userEnity);
    }
    @RequestMapping(value = "/toCreateUser",method = RequestMethod.GET)
    public String toCreateUser(){
        return "/homeworkjsp/register";
    }

    @RequestMapping(value = "/homeWorkKey",method = RequestMethod.POST)
    public @ResponseBody Map<String,Long> getHomeWorkKey(){
        Map<String,Long> keyMap=new HashMap<String, Long>();
        Long conentId=homeWorkService.getHomeWorkKey();
        keyMap.put("key",conentId);
        return keyMap;
    }


    @RequestMapping(value="/homeWorkInfo")
    public String homeWorkInfo(@RequestParam String admin,@RequestParam int limit,@RequestParam int offset){
      //  List<HomeWorkInfoDTO>  list =homeWorkService.getHomeWorkInfo();
      //  System.out.print(list.size());
        return null;
    }
    @RequestMapping(value="/homeWorkInfo1",method = RequestMethod.POST)
    @RequiresRoles("teacher")
    public @ResponseBody String homeWorkInfo1(@RequestBody Map<String,String> map){
        String listType=map.get("listType");
        List<HomeWorkInfoDTO>  list =homeWorkService.getHomeWorkInfo(listType);
        String string= JSON.toJSONString(list);
        return string;


    }
    @RequestMapping(value="/homeworkContent",method = RequestMethod.POST)
    public @ResponseBody Map<String,String> saveHomeWorkComment(@RequestBody HomeWorkCommentPo homeWorkCommentPo){
        homeWorkService.saveHomeWorkComment(homeWorkCommentPo);
        localSession.get().put("flag","1");
        return localSession.get();
    }



    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager2 = sessionManager;
    }

  }
