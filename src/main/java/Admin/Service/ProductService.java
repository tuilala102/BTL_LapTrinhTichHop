package Admin.Service;


import Admin.Entity.Customer;
import Admin.Entity.Product;
import Admin.Func.Fiter;
import Admin.Func.ProductFilterRequest;
import Admin.Repository.ProductRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ProductRepo repo;
    public List<Product> listAll(){
        return repo.findAll();
    }
    public long getCount(){
        return repo.count();
    }
    public Product getProductById(int id){
        return repo.findById(id).get();
    }
    public void save(Product product) {
        repo.save(product);
    }
    public void delete(int id) {
        repo.deleteById(id);
    }
    public List<Product> search(String keyword){
        return repo.searchProducts(keyword);
    }
    public List<Product> filterProduct(ProductFilterRequest filterRequest) {
        List<Integer> prices = filterRequest.getPrice();
        List<String> brands = filterRequest.getBrand();
        List<String> types = filterRequest.getSex();
        List<String> categories = filterRequest.getCategory();

        StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Product p");
        if (!prices.isEmpty() || !brands.isEmpty() || !types.isEmpty() || !categories.isEmpty()) {
            queryBuilder.append(" WHERE ");

            // filter price
            if (!prices.isEmpty()) {
                queryBuilder.append("(");
                for (int i = 0; i < prices.size(); i++) {
                    if (i > 0) {
                        queryBuilder.append(" OR ");
                    }
                    int price = prices.get(i);
                    switch (price) {
                        case 0:
                            queryBuilder.append("p.price < 1000000");
                            break;
                        case 1:
                            queryBuilder.append("(p.price >= 1000000 AND p.price < 2000000)");
                            break;
                        case 2:
                            queryBuilder.append("(p.price >= 2000000 AND p.price < 3000000)");
                            break;
                        case 3:
                            queryBuilder.append("(p.price >= 3000000 AND p.price < 5000000)");
                            break;
                        case 4:
                            queryBuilder.append("(p.price >= 5000000 AND p.price < 10000000)");
                            break;
                        case 5:
                            queryBuilder.append("p.price >= 10000000");
                            break;
                    }
                }
                queryBuilder.append(")");
            }

            // filter brands
            if (!brands.isEmpty()) {
                if (!prices.isEmpty()) {
                    queryBuilder.append(" AND ");
                }
                queryBuilder.append("(");
                for (int i = 0; i < brands.size(); i++) {
                    if (i > 0) {
                        queryBuilder.append(" OR ");
                    }
                    String brand = brands.get(i);
                    queryBuilder.append("p.brand = '").append(brand).append("'");
                }
                queryBuilder.append(")");
            }

            // filter types
            if (!types.isEmpty()) {
                if (!prices.isEmpty() || !brands.isEmpty()) {
                    queryBuilder.append(" AND ");
                }
                queryBuilder.append("(");
                for (int i = 0; i < types.size(); i++) {
                    if (i > 0) {
                        queryBuilder.append(" OR ");
                    }
                    String type = types.get(i);
                    queryBuilder.append("p.sex = '").append(type).append("'");
                }
                queryBuilder.append(")");
            }

            // filter categories
            if (!categories.isEmpty()) {
                if (!prices.isEmpty() || !brands.isEmpty() || !types.isEmpty()) {
                    queryBuilder.append(" AND ");
                }
                queryBuilder.append("(");
                for (int i = 0; i < categories.size(); i++) {
                    if (i > 0) {
                        queryBuilder.append(" OR ");
                    }
                    String category = categories.get(i);
                    queryBuilder.append("p.category = '").append(category).append("'");
                }
                queryBuilder.append(")");
            }
        }



        TypedQuery<Product> query = entityManager.createQuery(queryBuilder.toString(), Product.class);
        List<Product> products = query.getResultList();
        return products;
    }
}
