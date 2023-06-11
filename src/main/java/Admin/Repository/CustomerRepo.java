package Admin.Repository;

import Admin.Entity.Adds;

import org.springframework.data.jpa.repository.JpaRepository;
import Admin.Entity.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
//    Customer findBylogin( String username, String password);
  Customer findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
