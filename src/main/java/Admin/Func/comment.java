package Admin.Func;

public class comment {
    String content;
    int productid;
    String username;
    public comment(){}
    public comment(String content, int productid, String username) {
        this.content = content;
        this.productid = productid;
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
