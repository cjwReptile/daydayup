package HomeWorkManager.enity;

/**
 * Created by cjw on 2017/9/5.
 */
public class UserEnity {

    private String userName;

    private String password;

    private String salt;

    private boolean lock;

    private Long id;
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

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
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

  /*  @Override
    public int hashCode(){
        return id!=null?id.hashCode():0;
    }*/
}
