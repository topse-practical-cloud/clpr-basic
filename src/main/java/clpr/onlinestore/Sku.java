package clpr.onlinestore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="sku")
public class Sku {
    @Id
    @Column(name="id", nullable=false)
    private String id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="product_id", nullable=false)
    private String productId;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }
}