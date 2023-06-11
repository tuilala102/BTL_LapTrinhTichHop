package Admin.Func;

import java.util.List;

public class listProduct {
    int userid;
    List<products> product;
    public listProduct(){}
    public listProduct( List<products> product,int userid) {
        this.userid = userid;
        this.product = product;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public List<products> getProduct() {
        return product;
    }

    public void setProduct(List<products> product) {
        this.product = product;
    }
}
