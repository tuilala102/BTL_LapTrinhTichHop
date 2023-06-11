package Admin.Controller;

import Admin.Entity.News;
import Admin.Entity.Product;
import Admin.Func.OderItem;
import Admin.Func.listProduct;
import Admin.Func.products;
import Admin.Service.Odered_itemService;
import Admin.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class PaymentController {
    @Autowired
    private PaymentService service ;
    @GetMapping("/payment/getordered/")
    public List<Map<String, Object>> getAll()
    {
        return service.getAllOrderedItem();
    }
//    @Autowired
//    private Odered_itemService OderItemService;

    @GetMapping("/payment/orderedItems/{id}")
    public List<Map<String, Object>> getOrderedItems(@PathVariable int id) {
        return service.getOrderItem(id);
    }
    @PostMapping("/payment/delete")
    public ResponseEntity delete(@RequestBody OderItem oder) throws Exception{

        try
        {
            service.deleteOrderedItem(oder.getOrdItemId(),oder.getOrdCusId(),oder.getProductId());
            return ResponseEntity.status(200).body("success");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(304).body("Xóa sản phẩm không thành công!");
        }
    }
    @PostMapping("/payment/make")
    public ResponseEntity make(@RequestBody listProduct list) throws Exception{

        try
        {
            if(service.makePayment(list.getProduct(),list.getUserid())==true){
                return ResponseEntity.status(200).body("success");
            }

            return ResponseEntity.status(200).body("fail");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(405).body("Method Not Allowed");
        }
    }
}
