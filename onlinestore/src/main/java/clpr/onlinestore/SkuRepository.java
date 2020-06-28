package clpr.onlinestore;
 
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
 
public interface SkuRepository extends JpaRepository<Sku, String> {
    List<Sku>findByProductId(String productId);
}