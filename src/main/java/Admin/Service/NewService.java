package Admin.Service;

import Admin.Entity.News;
import Admin.Repository.NewRepo;
import Admin.Repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class NewService {
    @Autowired
    private NewRepo repo;
    public List<News> listAll(){
        return repo.findAll();
    }
    public long getCount(){
        return repo.count();
    }
    public News getNewById(int id){
        return repo.findById(id).get();
    }
    public void save(News n) {
        repo.save(n);
    }
    public void delete(int id) {
        repo.deleteById(id);
    }

}
