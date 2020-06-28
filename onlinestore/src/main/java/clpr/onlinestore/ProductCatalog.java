package clpr.onlinestore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="productcatalog")
public class ProductCatalog {
    @Id
    @Column(name="product_id", nullable=false)
    private String productId;

    @Column(name="product_name", nullable=false)
    private String productName;

    @Column(name="category", nullable=false)
    private String category;

    @Column(name="sumbnail_image_path", nullable=false)
    private String sumbnailImagePath;

    @Column(name="description", nullable=true)
    private String description;

    @Column(name="is_instock", nullable=true)
    private Boolean isInstock;

    @Column(name="created_at", nullable=false)
    private java.sql.Timestamp createdAt;

    public String getProductId(){
        return productId;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getSumbnailImagePath(){
        return sumbnailImagePath;
    }

    public void setSumbnailImagePath(String sumbnailImagePath){
        this.sumbnailImagePath = sumbnailImagePath;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Boolean getIsInstock(){
        return isInstock;
    }

    public void setIsInstock(Boolean isInstock){
        this.isInstock = isInstock;
    }

    public java.sql.Timestamp getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt){
        this.createdAt = createdAt;
    }
}