package ssm.model;

import java.io.Serializable;

/**
 * Created by hasee on 2017/4/27.
 */
public class UserBean implements Serializable{

    private  String userName;

    private  String passWord;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
