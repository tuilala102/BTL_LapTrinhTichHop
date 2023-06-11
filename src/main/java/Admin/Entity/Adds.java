package Admin.Entity;

import Admin.Func.AddsratingKey;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="adds")
public class Adds {
    @EmbeddedId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ratingKey")
            private AddsratingKey ratingKey;
    @ManyToOne
            @MapsId("productid")
            @JoinColumn(name="productid")
            private  Product product;
    @ManyToOne
            @MapsId("customid")
            @JoinColumn(name="customid")
            private  Customer customer;

    Date adddate;
    int quantity;
    public Adds(){

    }

    public Adds(AddsratingKey ratingKey, Product product, Customer customer, Date adddate, int quantity) {
        this.ratingKey = ratingKey;
        this.product = product;
        this.customer = customer;
        this.adddate = adddate;
        this.quantity = quantity;
    }

    public AddsratingKey getId() {
        return ratingKey;
    }

    public void setId(AddsratingKey ratingKey) {
        this.ratingKey = ratingKey;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
