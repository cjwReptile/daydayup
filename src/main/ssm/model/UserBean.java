package ssm.model;

import java.io.Serializable;

/**
 * Created by hasee on 2017/4/27.
 */
public class UserBean implements Serializable{

    private  String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
