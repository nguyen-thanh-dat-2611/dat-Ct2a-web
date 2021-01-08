
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productpromotion")
public class ProductPromotionEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     
     @ManyToOne
    @JoinColumn(name = "productID")
    private ProductsEntity products;
     
     @ManyToOne
    @JoinColumn(name = "promotionsID")
    private PromotionsEntity promotions;

    public ProductPromotionEntity() {
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductsEntity getProduct() {
        return products;
    }

    public void setProduct(ProductsEntity products) {
        this.products = products;
    }

    

    public PromotionsEntity getPromotions() {
        return promotions;
    }

    public void setPromotions(PromotionsEntity promotions) {
        this.promotions = promotions;
    }

   
    
    
}
