package clpr.onlinestore;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    
    @Retryable(value = { Exception.class }, maxAttempts = 3, backoff = @Backoff(delay = 500))
    @Transactional
    public OrderHistory sendOrder(String sku){
        UUID uuid = UUID.randomUUID();
        Inventory inventory = inventoryRepository.findBySkuId(sku);
        inventory.setStock(inventory.getStock() - 1);
        OrderHistory orderhistory = new OrderHistory();
        orderhistory.setSkuId(sku);
        orderhistory.setOrderId(uuid.toString());
        orderhistory.setOrderAt(new Timestamp(System.currentTimeMillis()));
        orderHistoryRepository.save(orderhistory);
        return orderhistory;
    }
}