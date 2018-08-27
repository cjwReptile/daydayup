package HomeWorkManager.enity.Integrate;

public class IntegratePlateScore {

    private int id;

    private int score;

    private int belongPlate;

    private String teaBelong;

    private String stuBelong;

    private int week;

    private String createTime;

    private String scoreInfo;

    public String getTeaBelong() {
        return teaBelong;
    }

    public void setTeaBelong(String teaBelong) {
        this.teaBelong = teaBelong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBelongPlate() {
        return belongPlate;
    }

    public void setBelongPlate(int belongPlate) {
        this.belongPlate = belongPlate;
    }

    public String getStuBelong() {
        return stuBelong;
    }

    public void setStuBelong(String stuBelong) {
        this.stuBelong = stuBelong;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getScoreInfo() {
        return scoreInfo;
    }

    public void setScoreInfo(String scoreInfo) {
        this.scoreInfo = scoreInfo;
    }
}
