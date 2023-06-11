package Admin.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="id")
    int id;
    String name;
    String image;
    String descript;
    String brand;
    String category;
    String sex;
    int price;
    int quantity;
    public Product(){

    }
    public Product(String name, String image, String descript, String brand, String category, String sex, int price,int quantity) {
        this.name = name;
        this.image = image;
        this.descript = descript;
        this.brand = brand;
        this.category = category;
        this.sex = sex;
        this.price = price;
        this.quantity=quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "Adds",
//    joinColumns = @JoinColumn(name = "productid"),
//    inverseJoinColumns = @JoinColumn(name = "customid"))
//    @JsonManagedReference
//    private Set<Customer> likedCostomer;
//
//    public Set<Customer> getLikedCostomer() {
//        return likedCostomer;
//    }
//
//    public void setLikedCostomer(Set<Customer> likedCostomer) {
//        this.likedCostomer = likedCostomer;
//    }
}
