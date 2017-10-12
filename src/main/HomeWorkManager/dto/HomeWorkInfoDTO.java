package HomeWorkManager.dto;

import HomeWorkManager.enity.HomeWorkLocationPo;

import java.util.Date;
import java.util.List;

/**
 * Created by cjw on 2017/9/28.
 */
public class HomeWorkInfoDTO {
    private Long userId;

    private String contentDescription;

    private Long contentId;

    private String contentAuthority;

    private Date contentTime;

    private String userName;

    private int size;



    private List<HomeWorkLocationPo> homeWorkLocationPos;

    public List<HomeWorkLocationPo> getHomeWorkLocationPos() {
        return homeWorkLocationPos;
    }

    public void setHomeWorkLocationPos(List<HomeWorkLocationPo> homeWorkLocationPos) {
        this.homeWorkLocationPos = homeWorkLocationPos;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getContentTime() {
        return contentTime;
    }

    public void setContentTime(Date contentTime) {
        this.contentTime = contentTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getContentAuthority() {
        return contentAuthority;
    }

    public void setContentAuthority(String contentAuthority) {
        this.contentAuthority = contentAuthority;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
