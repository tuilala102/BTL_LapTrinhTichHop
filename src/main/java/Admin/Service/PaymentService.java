package Admin.Service;

import Admin.Entity.Product;
import Admin.Func.products;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAllOrderedItem() {
        String sql = "SELECT product.id AS productId, product.name, product.image, product.brand, product.price, belong.quantity, customer.userName, ordered_item.orderDate, ordered_item.id AS orderId, customer.id AS customerId " +
                "FROM ((product JOIN belong ON product.id = belong.productId) JOIN ordered_item ON belong.ordCusId = ordered_item.cusId AND belong.ordItemId = ordered_item.id) JOIN customer ON ordered_item.cusId = customer.id";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        return resultList;
    }
    public List<Map<String, Object>> getOrderItem(int id) {
        String sql = "SELECT image, name, price, quantity, brand FROM ordered_item o JOIN product p ON o.id = p.id WHERE o.cusId = ?";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql, id);
        return resultList;
    }
    public List<Map<String,Object>> getPurch(int id){
        String sql = "SELECT image, name, price, quantity, brand FROM ordered_item o JOIN product p ON o.id = p.id WHERE o.cusId = ? and o.status=0";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql, id);
        return resultList;
    }
    public int deleteOrderedItem(int ordItemId, int ordCusId, int productId) {
        String sql = "DELETE FROM belong WHERE ordItemId = ? AND ordCusId = ? AND productId = ?";
        return jdbcTemplate.update(sql, ordItemId, ordCusId, productId);
    }


    @Transactional
    public boolean makePayment(List<products> products, int userId) {
        // delete from adds
        String where = "WHERE ";
        boolean first = true;
        for (products product : products) {
            if (first) {
                first = false;
                where += "productId = " + product.getId();
            } else {
                where += " OR productId = " + product.getId();
            }
        }
        String query1 = "DELETE FROM adds " + where + " AND customId = " + userId;
        int result1 = jdbcTemplate.update(query1);

        // add order item
        String tempQuery = "SELECT MAX(id) FROM ordered_item WHERE cusId = " + userId;
        int curId;
        try {
            curId = jdbcTemplate.queryForObject(tempQuery, Integer.class);
            curId++;
        } catch (NullPointerException e) {
            curId = 1;
        }

        String query2 = "";
        for (products product : products) {
            query2 += "INSERT INTO ordered_item(id, orderDate, cusId,status) VALUES(" + curId + ", NOW(), " + userId + ",0);";
        }
        int result2 = jdbcTemplate.update(query2);

        String query3 = "";
        for (products product : products) {
            query3 += "INSERT INTO belong(ordCusId, ordItemId, productId, quantity) VALUES(" + userId + ", " + curId + ", " + product.getId() + ", " + product.getQuantity() + ");";
        }
        int result3 = jdbcTemplate.update(query3);

        return result1 > 0 && result2 > 0 && result3 > 0;
    }
}
