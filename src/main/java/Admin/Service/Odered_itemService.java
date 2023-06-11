package Admin.Service;

import Admin.Repository.Odered_itemRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class Odered_itemService {
    @Autowired
    private Odered_itemRepo repo;

//    public List<Map<String, Object>> getOrderedItems(int cusId) {
//        return repo.findOrderedItems(cusId);
//    }
}
