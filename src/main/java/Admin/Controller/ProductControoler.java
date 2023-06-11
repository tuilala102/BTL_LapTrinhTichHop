package Admin.Controller;

import Admin.Entity.Customer;
import Admin.Entity.Product;
import Admin.Entity.login;
import Admin.Func.Fiter;
import Admin.Func.ProductFilterRequest;
import Admin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class ProductControoler {
    @Autowired
    private ProductService service;
    @CrossOrigin
    @GetMapping("/product/")
    public List<Product> getAll()
    {
        List<Product> list=service.listAll();

        return list;}
    @GetMapping("/product/detail/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){

        try
        {
            service.delete(id);
            return ResponseEntity.status(200).body("success");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(304).body("Xóa sản phẩm không thành công!");
        }
    }
    @PostMapping("/product/add")
    public ResponseEntity add(@RequestBody Product product) throws Exception
    {

        try
        {
            service.save(product);
            return ResponseEntity.status(200).body("success");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(304).body("Thêm mới sản phẩm không thành công!");
        }
    }
    @PutMapping("/product/update")
    public ResponseEntity updateCustomers(@RequestBody Product prod)
    {
        try {
            Product productUpdate = service.getProductById(prod.getId());
            productUpdate.setBrand(prod.getBrand());
            productUpdate.setCategory(prod.getCategory());
            productUpdate.setDescript(prod.getDescript());
            productUpdate.setName(prod.getName());
            productUpdate.setImage(prod.getImage());
            productUpdate.setSex(prod.getSex());
            productUpdate.setPrice(prod.getPrice());
            service.save(productUpdate);
            return ResponseEntity.status(200).body("success");
        }catch (Exception e) {
            return ResponseEntity.status(304).body("Sửa sản phẩm thất bại");
        }
    }
    @GetMapping("/product/search/{keyword}")
    public List<Product> Search(@PathVariable String keyword){
        return service.search(keyword);
    }
    @PostMapping("/product/fiter")
    public List<Product> fiter(@RequestBody ProductFilterRequest fiter)throws Exception
    {
        return service.filterProduct(fiter);
    }

}
