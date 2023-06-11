package Admin.Repository;


import Admin.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepo extends JpaRepository<News,Integer> {
}
