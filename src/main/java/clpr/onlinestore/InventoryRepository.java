package clpr.onlinestore;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface InventoryRepository extends JpaRepository<Inventory, String> {
    Inventory findBySkuId(String skuId);
}