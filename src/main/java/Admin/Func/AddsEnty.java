package Admin.Func;

import java.sql.Date;

public class AddsEnty {
    int customid;
    int productid;

    int quantity;
    public AddsEnty(){

    }
    public AddsEnty(int customid, int productid, int quantity) {
        this.customid = customid;
        this.productid = productid;

        this.quantity = quantity;
    }

    public int getCustomid() {
        return customid;
    }

    public void setCustomid(int customid) {
        this.customid = customid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
