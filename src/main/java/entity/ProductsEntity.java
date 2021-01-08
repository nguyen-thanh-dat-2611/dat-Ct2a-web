
package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private int id;
    private String name;
    private String configurationInfo;
    private String classer;
    private double price;
    private String image;
    
    @OneToMany(mappedBy = "products",fetch = FetchType.LAZY)
    List<OrderDetailsEntity> orderdetailslist; 
    
    @OneToMany(mappedBy = "products",fetch = FetchType.LAZY)
    List<ProductPromotionEntity> productpromotionlist; 
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryEntity category;

    public ProductsEntity() {
    }
    
        public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfigurationInfo() {
        return configurationInfo;
    }

    public void setConfigurationInfo(String configurationInfo) {
        this.configurationInfo = configurationInfo;
    }

    

    public String getClasser() {
        return classer;
    }

    public void setClasser(String classer) {
        this.classer = classer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<OrderDetailsEntity> getOrderdetailslist() {
        return orderdetailslist;
    }

    public void setOrderdetailslist(List<OrderDetailsEntity> orderdetailslist) {
        this.orderdetailslist = orderdetailslist;
    }

    public List<ProductPromotionEntity> getProductpromotionlist() {
        return productpromotionlist;
    }

    public void setProductpromotionlist(List<ProductPromotionEntity> productpromotionlist) {
        this.productpromotionlist = productpromotionlist;
    }

    

    
    
}
