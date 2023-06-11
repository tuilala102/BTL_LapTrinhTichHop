package Admin.Func;

import java.util.List;

public class ProductFilterRequest {
    private List<Integer> price;
    private List<String> brand;
    private List<String> sex;
    private List<String> category;
    public ProductFilterRequest(){}
    public ProductFilterRequest(List<Integer> price, List<String> brand, List<String> sex, List<String> category) {
        this.price = price;
        this.brand = brand;
        this.sex = sex;
        this.category = category;
    }

    public List<Integer> getPrice() {
        return price;
    }

    public void setPrice(List<Integer> price) {
        this.price = price;
    }

    public List<String> getBrand() {
        return brand;
    }

    public void setBrand(List<String> brand) {
        this.brand = brand;
    }

    public List<String> getSex() {
        return sex;
    }

    public void setSex(List<String> sex) {
        this.sex = sex;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }
}
