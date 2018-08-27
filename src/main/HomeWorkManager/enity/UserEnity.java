package HomeWorkManager.enity;

/**
 * Created by cjw on 2017/9/5.
 */
public class UserEnity {

    private String userName;

    private String password;

    private String salt;

    private String userId;

    private Boolean avalible=Boolean.FALSE;

    private Long id;

    private Integer type;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getAvalible() {
        return avalible;
    }

    public void setAvalible(Boolean avalible) {
        this.avalible = avalible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCredentialsSalt(){
        return userName+salt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /*  @Override
    public int hashCode(){
        return id!=null?id.hashCode():0;
    }*/
}
