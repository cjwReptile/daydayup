package ssm.dto;

import java.util.Date;

/**
 * Created by cjw on 2017/6/21.
 */
public class Exproser {
    /**
     *id
     */
    private Long secKillid;
    /**
     *加密url
     */
    private String md5;
    /**
     *是否开启秒杀
     */
    private boolean exproser;
    /**
     *秒杀开始时间
     */
    private Date startTime;
    /**
     *秒杀结束时间
     */
    private Date endTime;

    /**
     *当前时间
     */
    private Date now;
   /**
    *秒杀未开启，输出系统当前时间
    */
    public Exproser(Long secKillid, boolean exproser, Date startTime, Date endTime, Date now) {
        this.secKillid = secKillid;
        this.exproser = exproser;
        this.startTime = startTime;
        this.endTime = endTime;
        this.now = now;
    }
    /**
     *秒杀开启，返回url
     */
    public Exproser(Long secKillid, String md5, boolean exproser) {
        this.secKillid = secKillid;
        this.md5 = md5;
        this.exproser = exproser;
    }
    /**
     *秒杀结束
     */
    public Exproser(Long secKillid, boolean exproser) {
        this.secKillid = secKillid;
        this.exproser = exproser;
    }

    public Long getSecKillid() {
        return secKillid;
    }

    public void setSecKillid(Long secKillid) {
        this.secKillid = secKillid;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public boolean isExproser() {
        return exproser;
    }

    public void setExproser(boolean exproser) {
        this.exproser = exproser;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }
}
