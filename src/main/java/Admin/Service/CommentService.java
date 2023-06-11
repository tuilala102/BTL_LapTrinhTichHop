package Admin.Service;

import Admin.Entity.Comment;
import Admin.Func.comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> getAllOrderedItem(int id) {
        String sql = "SELECT * FROM comment WHERE productid = ?";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql,id);
        return resultList;
    }
    public int deleteComment(int ordItemId, int ordCusId, int productId) {
        String sql = "DELETE FROM comment WHERE id =? AND productId = ?";
        return jdbcTemplate.update(sql, ordItemId, ordCusId, productId);
    }
    public void post(comment comment){
        String sql="iNSERT INTO `comment` VALUES (NULL, ?, Now(), ?, ?)";
        jdbcTemplate.update(sql,comment.getContent(),comment.getProductid(),comment.getUsername());
    }
}
