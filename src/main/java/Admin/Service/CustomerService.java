package Admin.Service;
import Admin.Entity.Customer;
import Admin.Entity.login;
import Admin.Func.signup;
import jakarta.transaction.Transactional;
import Admin.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CustomerRepo repo;
    public Customer login(String username, String password){
        return repo.findByUsernameAndPassword(username, password);
    }
    public List<Customer> listAll() {
        return repo.findAll();
    }

    public void save(Customer customers) {
        repo.save(customers);
    }
    public int signup(signup sig){
        String sql = "INSERT INTO `customer` VALUES (NULL,?,NULL,NULL, ?, NOW(),0,0, ?)";
        return jdbcTemplate.update(sql, sig.getUsername(), sig.getPassword(), sig.getPhonenum());
    }

    public Customer getCustomerById(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

}
