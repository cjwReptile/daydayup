package HomeWorkManager.enity;

/**
 * Created by cjw on 2017/10/13.
 */
public class HomeWorkCommentPo {

    private Long contentId;

    private String comment;

    private int score;

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
