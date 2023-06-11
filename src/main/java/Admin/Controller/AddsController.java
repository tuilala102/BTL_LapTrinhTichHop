package Admin.Controller;

import Admin.Entity.Adds;
import Admin.Entity.Customer;
import Admin.Entity.News;
import Admin.Entity.Product;
import Admin.Func.AddsEnty;
import Admin.Func.AddsratingKey;
import Admin.Func.listProduct;
import Admin.Service.AddsService;
import Admin.Service.CustomerService;
import Admin.Service.NewService;
import Admin.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class AddsController {
    @Autowired
    private AddsService service;
    private CustomerService CusS;
    private ProductService ProS;
    @CrossOrigin
    @GetMapping("/cart/{id}")
    public List<Map<String, Object>> getAll(@PathVariable int id)
    {


        return service.getList(id);
    }
    @PostMapping("/cart/add")
    public ResponseEntity addCustomers(@RequestBody AddsEnty addsEnty) throws Exception
    {
//        Adds adds=new Adds();
//        adds.setAdddate(addsEnty.getAdddate());
//        adds.setQuantity(addsEnty.getQuantity());
//        AddsratingKey RatingKey=new AddsratingKey();
//        RatingKey.setCustomid(addsEnty.getCustomid());
//        RatingKey.setProductid(addsEnty.getProductid());
//        adds.setId(RatingKey);
//        Customer Cus=CusS.getCustomerById(addsEnty.getCustomid()).orElseThrow(() -> new NotFoundException("Customer not found"));;
//        Product Pro=ProS.getProductById(addsEnty.getProductid());
//        adds.setProduct(Pro);
//        adds.setCustomer(Cus);
        try
        {
           int result= service.Add1(addsEnty);
           if(result==1) {
               return ResponseEntity.status(200).body("success");
           } else return ResponseEntity.status(304).body("Thêm mới sản phẩm không thành công!");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(304).body("Thêm mới sản phẩm không thành công!");
        }
    }
    @PostMapping("/cart/delete")
    public ResponseEntity delete(@RequestBody AddsratingKey addsk) throws  Exception
    {
        try
        {
            int result= service.deleteCart(addsk);
            if(result==1) {
                return ResponseEntity.status(200).body("success");
            } else return ResponseEntity.status(304).body("Xoa sản phẩm không thành công!");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(304).body("Xóa sản phẩm không thành công!");
        }
    }
    @PutMapping("/cart/update")
    public ResponseEntity updateCustomers(@RequestBody listProduct add)throws  Exception
    {
        try {

            service.Update(add);
            return ResponseEntity.status(200).body("success");
        }catch (Exception e) {
            return ResponseEntity.status(304).body("Sửa sản phẩm thất bại");
        }
    }
}
