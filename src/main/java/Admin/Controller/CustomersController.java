package Admin.Controller;
import Admin.Entity.Customer;
import Admin.Entity.Product;
import Admin.Entity.login;
import Admin.Func.signup;
import Admin.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Hashtable;
import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class CustomersController {

    @Autowired 
    private CustomerService service;
    @CrossOrigin
    @GetMapping("/customer/")
    public List<Customer> getAll()
    {
        List<Customer> list=service.listAll();
        return list;
//        List<CustomerF> ds ;
//
//            for (Customer Cu:list
//            ) {
//                CustomerF CustomerF=new CustomerF();
//                CustomerF.setActive(String.valueOf (Cu.getActive()));
//                CustomerF.setAddress(Cu.getAddress());
//                CustomerF.setBdate(Cu.getBdate());
//                CustomerF.setBklock(String.valueOf(Cu.getBklock()));
//                CustomerF.setId(String.valueOf(Cu.getPassword()));
//                CustomerF.setFullname(Cu.getFullname());
//                CustomerF.setPassword(Cu.getPassword());
//                CustomerF.setPhonenum(Cu.getPhonenum());
//            CustomerF.setUsername(Cu.getUsername());
//            ds.add(CustomerF);
//
//        }
        
        //List<Customer> ListCustomer=service.listAll();
        //List<Customer> listCustomer =service.listAll();

    }
    @GetMapping("/customer/detail/{id}")
    public Customer getCus(@PathVariable int id)
    {
        Customer Cus=service.getCustomerById(id);
        return Cus;
    }
    @PostMapping("/customer/login")
    public Customer login(@RequestBody login login)throws Exception
    {
        Customer Cus=service.login(login.getUsername(), login.getPassword());
        return Cus;
    }



    @PostMapping("/customer/signup")
    public ResponseEntity addCustomers(@RequestBody signup customer) throws Exception
    {
        try
        {

            if(service.signup(customer)==1){
                return ResponseEntity.status(200).body("success");
            }else
            return ResponseEntity.status(304).body("fail");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(304).body("Thêm mới khách hàng không thành công!");
        }
    }

//    public @ResponseBody Hashtable deleteUser(@RequestParam int id){
//        Hashtable<String,Object> repo=new Hashtable<String, Object>();
//        Customer newCus=new Customer(id);
//        service.delete(id);
//        repo.put("result","OK");
//        repo.put("data",newCus);
//        repo.put("message","Ok");
//        return repo;
//    }
    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity deleteuser(@PathVariable int id)
    {
        try
        {
            service.delete(id);
            return ResponseEntity.status(200).body("success");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(304).body("Xóa khách hàng không thành công!");
        }

    }


    @PutMapping("/customer/update")
    public ResponseEntity updateCustomers(@RequestBody Customer user)
    {
        try {
            Customer customerUpdate = service.getCustomerById(user.getId());
            customerUpdate.setUsername(user.getUsername());
            customerUpdate.setFullname(user.getFullname());
            customerUpdate.setAddress(user.getAddress());
            customerUpdate.setPassword(user.getPassword());
            customerUpdate.setBdate(user.getBdate());

            customerUpdate.setPhonenum(user.getPhonenum());
            customerUpdate.setActive(user.getActive());
            service.save(customerUpdate);
            return ResponseEntity.status(200).body("success");
        }catch (Exception e) {
            return ResponseEntity.status(304).body("Sửa khách hàng thất bại");
        }
    }
}
