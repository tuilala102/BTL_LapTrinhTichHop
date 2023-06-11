package Admin.Repository;


import Admin.Entity.Odered_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Odered_itemRepo extends JpaRepository<Odered_item,Integer> {
//    @Query("insert into ordered_item(id, orderDate, cusId) values(:id, NOW(),:cusid")
//    void save(@Param("id") int id,@Param("cusid") int cusid );

//    @Query(value = "SELECT p.image, p.name, p.price, o.quantity, p.brand FROM ordered_item o JOIN product p ON o.productId = p.id WHERE o.cusId = :cusId", nativeQuery = true)
//    List<Map<String, Object>> findOrderedItems(@Param("cusId") int cusId);
}
