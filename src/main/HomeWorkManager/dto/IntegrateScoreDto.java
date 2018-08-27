package HomeWorkManager.dto;

/**
 * @Auther: cjw
 * @Date: 2018/8/13 09:13
 * @Description:
 */
public class IntegrateScoreDto {

    private int id;

    private String studentId;

    private String studentName;

    private int score;

    private String teacherId;

    private int belongPlate;

    private String createTime;

    private int timeModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getBelongPlate() {
        return belongPlate;
    }

    public void setBelongPlate(int belongPlate) {
        this.belongPlate = belongPlate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(int timeModel) {
        this.timeModel = timeModel;
    }
}
