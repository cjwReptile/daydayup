package ssm.model;

import java.util.Date;

/**
 * Created by cjw on 2017/6/21.
 */
public class SuccessKill {
    /**
     *秒杀id
     */
    private Long secKillid;
    /**
     *手机号码
     */
    private Long phone;
    /**
     *秒杀成功时间
     */
    private Date createTime;
    /**
     *秒杀对象
     */
    private SecKill secKill;

    public Long getSecKillid() {
        return secKillid;
    }

    public void setSecKillid(Long secKillid) {
        this.secKillid = secKillid;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SecKill getSecKill() {
        return secKill;
    }

    public void setSecKill(SecKill secKill) {
        this.secKill = secKill;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     *秒杀状态
     */
    private String state;

}
