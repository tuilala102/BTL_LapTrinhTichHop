package Admin.Controller;

import Admin.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class PurchController {
    @Autowired
    private PaymentService service ;
    @GetMapping("/purch/{id}")
    public List<Map<String, Object>> getOrderedItems(@PathVariable int id) {
        return service.getPurch(id);
    }
}
