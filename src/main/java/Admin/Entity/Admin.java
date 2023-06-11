//package Admin.Entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class Admin {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//    String username;
//    String fristname;
//    String midname;
//    String lastname;
//    String password;
//
//    public Admin() {
//
//    }
//
//    public Admin(String username, String fristname, String midname, String lastname, String password) {
//        this.username = username;
//        this.fristname = fristname;
//        this.midname = midname;
//        this.lastname = lastname;
//        this.password = password;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getFristname() {
//        return fristname;
//    }
//
//    public void setFristname(String fristname) {
//        this.fristname = fristname;
//    }
//
//    public String getMidname() {
//        return midname;
//    }
//
//    public void setMidname(String midname) {
//        this.midname = midname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
