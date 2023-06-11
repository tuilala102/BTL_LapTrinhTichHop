package Admin.Controller;

import Admin.Entity.Comment;
import Admin.Func.OderItem;
import Admin.Func.comment;
import Admin.Service.CommentService;
import Admin.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private CommentService service;
    @GetMapping("/comment/{id}")
    public List<Map<String, Object>> getAll(@PathVariable int id)
    {
        return service.getAllOrderedItem(id);
    }
    @PostMapping("/comment/post")
    public ResponseEntity delete(@RequestBody comment comment) throws Exception{

        try
        {
            service.post(comment);
            return ResponseEntity.status(200).body("success");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(304).body("them comment không thành công!");
        }
    }
}
