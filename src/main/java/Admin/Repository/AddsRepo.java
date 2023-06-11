package Admin.Repository;

import Admin.Entity.Adds;
import Admin.Func.AddsratingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface
AddsRepo extends JpaRepository<Adds,AddsratingKey> {

    List<Adds> findByRatingKey_Customid(@Param("customid") int customid);
    Adds findByRatingKey(@Param("id") AddsratingKey ratingKey);
   void deleteByRatingKey(@Param("id") AddsratingKey ratingKey);

 //   void deleteById_CustomidAndId_ProductId(@Param("customid") int customid,@Param("productid") int productid);

}
