package Admin.Func;

import java.sql.Date;

public class signup {
    private String username;

    private String password;

    private String phonenum;
    public signup(){}
    public signup(String username, String password, String phonenum) {
        this.username = username;
        this.password = password;
        this.phonenum = phonenum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
}
