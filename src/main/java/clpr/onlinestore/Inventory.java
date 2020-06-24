package clpr.onlinestore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="inventory")
public class Inventory {
    @Id
    @Column(name="sku_id", nullable=false)
    private String skuId;

    @Column(name="stock", nullable=false)
    private Integer stock;

    public String getSkuId(){
        return skuId;
    }

    public void setSku(String skuId){
        this.skuId = skuId;
    }

    public Integer getStock(){
        return stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }
}