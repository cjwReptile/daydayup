package HomeWorkManager.dto;

/**
 * @Auther: cjw
 * @Date: 2018/8/16 22:30
 * @Description:
 */
public class TeacherDto {

    private int id;

    private String teacherName;

    private String teacherId;

    private String teacherType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }
}
