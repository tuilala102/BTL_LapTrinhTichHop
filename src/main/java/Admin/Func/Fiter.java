package Admin.Func;

public class Fiter {
    int price;
    String brand;
    String category;
    String sex;
    public Fiter(){

    }
    public Fiter(int price, String brand, String category, String sex) {
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.sex = sex;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
