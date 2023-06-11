package Admin.Service;

import Admin.Entity.Adds;
import Admin.Entity.Customer;
import Admin.Entity.Product;
import Admin.Func.AddsEnty;
import Admin.Func.AddsratingKey;
import Admin.Func.listProduct;
import Admin.Func.products;
import Admin.Repository.AddsRepo;
import Admin.Repository.CustomerRepo;
import Admin.Repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AddsService {
    @Autowired
    private AddsRepo repo;
    @Autowired
    private CustomerRepo CusRepo;
    @Autowired
    private ProductRepo ProRepo;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int Add1(AddsEnty addsEnty){
        String sql="insert into adds(customid,productid,adddate,quantity) value(?,?,Now(),?)";
       int jdbc= jdbcTemplate.update(sql,addsEnty.getCustomid(),addsEnty.getProductid(),addsEnty.getQuantity());
       return jdbc;
    }
    public void Update(listProduct list){

        int cusId = list.getUserid();
        List<products> pro=list.getProduct();
        String query = "";
        for (products p:pro) {
            query += "UPDATE adds SET quantity = '" + p.getQuantity() + "' WHERE adds.customId = " + cusId + " AND adds.productId = " + p.getId() + ";";
        }
         jdbcTemplate.update(query);

    }

//    public void Add(AddsEnty addsEnty)  {
//        Adds adds=new Adds();
//        adds.setAdddate(addsEnty.getAdddate());
//        adds.setQuantity(addsEnty.getQuantity());
//        AddsratingKey RatingKey=new AddsratingKey();
//        RatingKey.setCustomid(addsEnty.getCustomid());
//        RatingKey.setProductid(addsEnty.getProductid());
//        adds.setId(RatingKey);
//        Customer cus = CusRepo.findById(addsEnty.getCustomid()).orElseThrow();
//       //Product pro=ProRepo.findById(addsEnty.getProductid()).orElseThrow(NotFoundException::new);
//        Product pro=ProRepo.findById(addsEnty.getProductid()).orElseThrow();
//        adds.setProduct(pro);
//        adds.setCustomer(cus);
//        repo.save(adds);
//    }
    public List<Adds> get(int id){
        AddsratingKey add=new AddsratingKey();
        add.setCustomid(id);
        return repo.findByRatingKey_Customid(id);
    }
    public List<Map<String, Object>> getList(int id) {
        String sql = "SELECT id, image, name, price, quantity, brand FROM `adds`, `product` WHERE productId = id AND customId = ?";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql, id);
        return resultList;
    }
    public void save(Adds adds) {
        repo.save(adds);
    }
    public void delete(AddsratingKey adds){

        repo.deleteByRatingKey(adds);
    }
    public int deleteCart(AddsratingKey adds){
        String sql = "DELETE FROM `adds` WHERE `adds`.`customId` = ? AND `adds`.`productId` = ?";
        int jdbc= jdbcTemplate.update(sql,adds.getCustomid(),adds.getProductid());
        return jdbc;
    }
    public Adds getId(AddsratingKey id){
        return repo.findByRatingKey(id);
    }
}
