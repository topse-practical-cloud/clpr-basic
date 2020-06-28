package clpr.onlinestore;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, String> {
    ProductCatalog findByProductId(String productId);
}