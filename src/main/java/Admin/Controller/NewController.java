package Admin.Controller;

import Admin.Entity.News;
import Admin.Entity.Product;
import Admin.Service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class NewController {
    @Autowired
    private NewService service;
    @CrossOrigin
    @GetMapping("/new/")
    public List<News> getAll()
    {
        List<News> list=service.listAll();

        return list;
    }
    @GetMapping("/new/detail/{id}")
    public News getNewById(@PathVariable int id){
        return service.getNewById(id);
    }
    @DeleteMapping("/new/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){

        try
        {
            service.delete(id);
            return ResponseEntity.status(200).body("success");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(304).body("Xóa tin mới không thành công!");
        }
    }
    @PostMapping("/new/add")
    public ResponseEntity add(@RequestBody News n) throws Exception
    {

        try
        {
            service.save(n);
            return ResponseEntity.status(200).body("success");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(304).body("Thêm tin mới không thành công!");
        }
    }
    @PutMapping("/new/update")
    public ResponseEntity updateCustomers(@RequestBody News n)
    {
        try {
            News newUpdate=service.getNewById((n.getId()));
            newUpdate.setContent(n.getContent());
            newUpdate.setAdminid(n.getAdminid());
            newUpdate.setLiked(n.getLiked());
            newUpdate.setNewdate(n.getNewdate());
            newUpdate.setView(n.getView());

            service.save(newUpdate);
            return ResponseEntity.status(200).body("success");
        }catch (Exception e) {
            return ResponseEntity.status(304).body("Sửa tin mới thất bại");
        }
    }
}
