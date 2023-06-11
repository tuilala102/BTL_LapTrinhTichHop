package Admin.Entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
    private int id;
    private String username;
    private String fullname;
    private String address;
    private String password;
    private Date bdate;

    private int active;
    private String phonenum;
    public Customer() {
    }
    public Customer(int id) {
        this.id=id;
    }
    public Customer(String username, String fullname, String address, String password, Date bdate,  int active, String phonenum) {
        this.username = username;
        this.fullname = fullname;
        this.address = address;
        this.password = password;
        this.bdate = bdate;

        this.active = active;
        this.phonenum = phonenum;
    }
    public Customer(String username, String password,  String phonenum) {

        this.username = username;

        this.password = password;

        this.phonenum = phonenum;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }



    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
//    @ManyToMany(mappedBy = "likedCostomer")
//    @JsonBackReference
//    private Set<Product> likes;
//
//    public Set<Product> getLikes() {
//        return likes;
//    }
//
//    public void setLikes(Set<Product> likes) {
//        this.likes = likes;
//    }
}
