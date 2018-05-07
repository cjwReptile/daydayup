package HomeWorkManager.dto;

import HomeWorkManager.enity.Integrate.IntegratePlateSon;

import java.util.Date;
import java.util.List;

public class IntegrateInfoDto {

    private int id;

    private String plateName;

    private String plateBelong;

    private int createId;

    private Date createTime;

    private Date updateTime;

    private String updateTimeStr;

    private List<IntegratePlateSon> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }


    public int getCreateId() {
        return createId;
    }

    public void setCreateId(int createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<IntegratePlateSon> getList() {
        return list;
    }

    public void setList(List<IntegratePlateSon> list) {
        this.list = list;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPlateBelong() {
        return plateBelong;
    }

    public void setPlateBelong(String plateBelong) {
        this.plateBelong = plateBelong;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }
}
