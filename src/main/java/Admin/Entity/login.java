package Admin.Entity;

public class login {
    String password;
    String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public login(){

    }
    public login(String password, String username) {
        this.password = password;
        this.username = username;
    }
}
