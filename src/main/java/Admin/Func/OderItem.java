package Admin.Func;

public class OderItem {
    int ordItemId;
    int ordCusId;
    int productId;
    public OderItem(){}
    public OderItem(int ordItemId, int ordCusId, int productId) {
        this.ordItemId = ordItemId;
        this.ordCusId = ordCusId;
        this.productId = productId;
    }

    public int getOrdItemId() {
        return ordItemId;
    }

    public void setOrdItemId(int ordItemId) {
        this.ordItemId = ordItemId;
    }

    public int getOrdCusId() {
        return ordCusId;
    }

    public void setOrdCusId(int ordCusId) {
        this.ordCusId = ordCusId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
