package ssm.dto;

import ssm.enums.SecKIllEnum;
import ssm.model.SuccessKill;

/**
 * Created by cjw on 2017/6/21.
 */
public class SecKillExcution {

    private Long secKillId;
    /**
     *秒杀状态
     */
    private int state;
    /**
     *秒杀状态信息
     */
    private String stateInfo;
    /**
     *秒杀成功对象
     */

    private SuccessKill successKill;
    /**
     *秒杀失败
     */
    public SecKillExcution(Long secKillId, SecKIllEnum secKIllEnum) {
        this.secKillId = secKillId;
        this.state = secKIllEnum.getState();
        this.stateInfo = secKIllEnum.getStateInfo();
    }

    public SecKillExcution(Long secKillId, SecKIllEnum secKIllEnum, SuccessKill successKill) {
        this.secKillId = secKillId;
        this.state = secKIllEnum.getState();
        this.stateInfo=secKIllEnum.getStateInfo();
        this.successKill = successKill;
    }

    /**
     *秒杀成功
     */


    public Long getSecKillId() {
        return secKillId;
    }

    public void setSecKillId(Long secKillId) {
        this.secKillId = secKillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKill getSuccessKill() {
        return successKill;
    }

    public void setSuccessKill(SuccessKill successKill) {
        this.successKill = successKill;
    }


}
