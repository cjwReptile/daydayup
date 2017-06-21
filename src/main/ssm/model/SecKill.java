package ssm.model;

import java.util.Date;

/**
 * Created by cjw on 2017/6/21.
 */
public class SecKill {
     /**
      *秒杀id
      */
     private Long secKillId;
     /**
      *秒杀开始时间
      */
     private Date startTime;
     /**
      *秒杀结束时间
      */
     private Date endTime;
     /**
      *库存数量
      */
     private  int number;
     /**
      *m商品名称
      */
     private  String name;

    public Long getSecKillId() {
        return secKillId;
    }

    public void setSecKillId(Long secKillId) {
        this.secKillId = secKillId;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
      *商品入库时间
      */
     private Date createTime;


}
