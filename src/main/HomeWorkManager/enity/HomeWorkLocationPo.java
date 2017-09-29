package HomeWorkManager.enity;

import java.util.Date;

/**
 * Created by cjw on 2017/9/28.
 */
public class HomeWorkLocationPo {
    private String contentId;

    private String contentUrl;

    private String contentType;

    private Date contentTime;

    private Long contentLocationId;

    public Long getContentLocationId() {
        return contentLocationId;
    }

    public void setContentLocationId(Long contentLocationId) {
        this.contentLocationId = contentLocationId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getContentTime() {
        return contentTime;
    }

    public void setContentTime(Date contentTime) {
        this.contentTime = contentTime;
    }
}
