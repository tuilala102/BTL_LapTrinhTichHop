package Admin.Repository;

import Admin.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByPriceAndBrandAndCategoryAndSex(@Param("price") int price,@Param("brand") String brand,@Param("category") String category,@Param("sex") String sex);
    List<Product> findByNameContainingIgnoreCase(@Param("name") String name);
    List<Product> findByDescriptContainingIgnoreCase(@Param("descript") String descript);
    List<Product> findByBrandContainingIgnoreCase(@Param("brand") String brand);
    List<Product> findByCategoryContainingIgnoreCase(@Param("category") String category);
    List<Product> findBySexContainingIgnoreCase(@Param("sex") String sex);
//    List<Product> findByPriceContainingIgnoreCase(@Param("price") String keyword);
    default List<Product> searchProducts(String keyword) {
        List<Product> result = new ArrayList<>();
        result.addAll(findByNameContainingIgnoreCase(keyword));
        result.addAll(findByDescriptContainingIgnoreCase(keyword));
        result.addAll(findByCategoryContainingIgnoreCase(keyword));
        result.addAll(findByBrandContainingIgnoreCase(keyword));
        result.addAll(findBySexContainingIgnoreCase(keyword));
//        result.addAll(findByPriceContainingIgnoreCase(keyword));
        return result;
    }
}
