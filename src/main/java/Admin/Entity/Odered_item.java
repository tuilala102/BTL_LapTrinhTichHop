package Admin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Odered_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date orderdate;
    int cusid;
    Boolean status;
    public Odered_item(){

    }
    public Odered_item(Date orderdate, int cusid,Boolean status) {
        this.orderdate = orderdate;
        this.cusid = cusid;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
