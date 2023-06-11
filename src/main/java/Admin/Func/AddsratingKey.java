package Admin.Func;

import jakarta.persistence.Column;

import java.io.Serializable;

public class AddsratingKey implements Serializable {

    @Column(name="customid")
    int customid;
    @Column(name="productid")
    int productid;
    public AddsratingKey(){

    }
    public AddsratingKey( int customid,int productid) {
        this.productid = productid;
        this.customid = customid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getCustomid() {
        return customid;
    }

    public void setCustomid(int customid) {
        this.customid = customid;
    }
}
