package clpr.onlinestore;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductCatalogRepository productCatalogRepository;
        
    @Retryable(value = { Exception.class }, maxAttempts = 3, backoff = @Backoff(delay = 500))
    @Transactional(readOnly = true)
    public List<ProductCatalog> getFeaturedProduct(){
        List<ProductCatalog> productCatalogs = productCatalogRepository.findAll();
        return productCatalogs;
    }

    @Retryable(value = { Exception.class }, maxAttempts = 3, backoff = @Backoff(delay = 500))
    @Transactional(readOnly = true)
    public ProductCatalog getProductById(String productId){
        ProductCatalog productCatalogs = productCatalogRepository.findByProductId(productId);
        return productCatalogs;
    }
}