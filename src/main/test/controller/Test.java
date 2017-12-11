package test.controller;

import HomeWorkManager.service.HomeWorkService;
import ssm.service.DayDayUpService;

import javax.annotation.Resource;

/**
 * Created by cjw on 2017/9/7.
 */

public class Test {
    @Resource
    private HomeWorkService homeWorkService;
    @Resource
    private DayDayUpService dayDayUpService;

    @org.junit.Test
    public void Test1111111(){
     //   List<HomeWorkInfoDTO> lsit= homeWorkService.getHomeWorkInfo();
    //    System.out.print(lsit.size());
    }
}
