package clpr.onlinestore;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SkuService {
    @Autowired
    private SkuRepository skuRepository;

    @Retryable(value = { Exception.class }, maxAttempts = 3, backoff = @Backoff(delay = 500))
    @Transactional(readOnly = true)
    public List<Sku> getSkuByProductId(String productId){
        List<Sku> skus = skuRepository.findByProductId(productId);
        return skus;
    }
}