package clpr.onlinestore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="orderhistory")
public class OrderHistory {
    @Id
    @Column(name="order_id", nullable=false)
    private String orderId;

    @Column(name="sku_id", nullable=false)
    private String skuId;

    @Column(name="order_at", nullable=false)
    private java.sql.Timestamp orderAt;

    public String getOrderId(){
        return orderId;
    }

    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public String getSkuId(){
        return skuId;
    }

    public void setSkuId(String skuId){
        this.skuId = skuId;
    }

    public java.sql.Timestamp getOrderAt(){
        return orderAt;
    }

    public void setOrderAt(java.sql.Timestamp orderAt){
        this.orderAt = orderAt;
    }
}