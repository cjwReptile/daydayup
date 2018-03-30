package HomeWorkManager.dto;

import HomeWorkManager.enity.Integrate.IntegratePlateSon;

import java.util.Date;
import java.util.List;

public class IntegrateInfoDto {

    private int id;

    private String plateName;

    private int parentBelong;

    private int createId;

    private Date createTime;

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

    public int getParentBelong() {
        return parentBelong;
    }

    public void setParentBelong(int parentBelong) {
        this.parentBelong = parentBelong;
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
}
