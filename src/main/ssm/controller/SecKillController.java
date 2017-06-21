package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.Exceptions.RepeatSecKillException;
import ssm.Exceptions.SecKillCloseException;
import ssm.Exceptions.SecKillException;
import ssm.dto.Exproser;
import ssm.dto.SecKillExcution;
import ssm.dto.SecKillResult;
import ssm.enums.SecKIllEnum;
import ssm.model.SecKill;
import ssm.service.SecKillService;

import java.util.Date;
import java.util.List;

/**
 * Created by cjw on 2017/6/21.
 */
@Controller
@RequestMapping("/seckill")
public class SecKillController {

    @Autowired
    private SecKillService service;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<SecKill> secKills=service.queryAll(0,4);
        model.addAttribute("list",secKills);
        return "seckill-main";
    }
    /**
     *暴露秒杀接口
     */
    @RequestMapping(value = "/{secKillId}/secKillUrl",
                    method = RequestMethod.POST,
                    produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SecKillResult<Exproser> exposer(Model model, @PathVariable("secKillId") Long secKillId){
         SecKillResult<Exproser> result;
         try {
             Exproser exproser=service.getSecKillUrl(secKillId);
             return new SecKillResult<Exproser>(true,exproser);
         }catch (Exception e){
             return new SecKillResult<Exproser>(false,e.getMessage());
         }
    }

    /**
     *@Author  cjw
     *@Date 2017/6/21 16:31
     *@Description 执行秒杀方法
     */
    @RequestMapping(value = "/{secKillId}/{md5}/excuteSecKill",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SecKillResult<SecKillExcution> excuteSecKill(Model model,Long secKillId,String md5,Long userPhone){
           try {
               SecKillExcution secKillExcution=service.excuteSecKill(secKillId,userPhone,md5);
               return new SecKillResult<SecKillExcution>(true,secKillExcution);
           }catch (RepeatSecKillException e1){
               SecKillExcution secKillExcution=new SecKillExcution(secKillId, SecKIllEnum.REPAET_KILL);
               return new SecKillResult<SecKillExcution>(true,secKillExcution);
           }catch (SecKillCloseException e2){
               SecKillExcution secKillExcution=new SecKillExcution(secKillId,SecKIllEnum.END);
               return new SecKillResult<SecKillExcution>(true,secKillExcution);
           }catch (SecKillException e3){
               SecKillExcution secKillExcution=new SecKillExcution(secKillId,SecKIllEnum.DATA_REWRITE);
               return new SecKillResult<SecKillExcution>(true,secKillExcution);
           }catch (Exception e4){
               SecKillExcution secKillExcution=new SecKillExcution(secKillId,SecKIllEnum.INNER_ERROR);
               return new SecKillResult<SecKillExcution>(true,secKillExcution);
           }
    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public SecKillResult<Long> time(){
        Date now = new Date();
        return new SecKillResult<Long>(true,now.getTime());
    }
}
