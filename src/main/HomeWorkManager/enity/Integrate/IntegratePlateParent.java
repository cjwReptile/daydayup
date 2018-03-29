package HomeWorkManager.enity.Integrate;

import java.util.Date;

public class IntegratePlateParent {

    private int id;

    private String plateName;

    private int parentBelong;

    private int createId;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;

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
}
