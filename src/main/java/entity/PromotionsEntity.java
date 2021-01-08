
package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "promotions")
public class PromotionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private String discountproducts;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStar;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateClose;
    
    private String descrption;
    private double price;
    
    @OneToMany(mappedBy = "promotions",fetch = FetchType.LAZY)
    List<ProductPromotionEntity> productsPromotionslist;

    public PromotionsEntity(String discountproducts, LocalDate dateStar, LocalDate dateClose, String descrption, double price, List<ProductPromotionEntity> productsPromotionslist) {
        this.discountproducts = discountproducts;
        this.dateStar = dateStar;
        this.dateClose = dateClose;
        this.descrption = descrption;
        this.price = price;
        this.productsPromotionslist = productsPromotionslist;
    }

    public String getDiscountproducts() {
        return discountproducts;
    }

    public void setDiscountproducts(String discountproducts) {
        this.discountproducts = discountproducts;
    }

    public LocalDate getDateStar() {
        return dateStar;
    }

    public void setDateStar(LocalDate dateStar) {
        this.dateStar = dateStar;
    }

    public LocalDate getDateClose() {
        return dateClose;
    }

    public void setDateClose(LocalDate dateClose) {
        this.dateClose = dateClose;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    

    public List<ProductPromotionEntity> getProductsPromotionslist() {
        return productsPromotionslist;
    }

    public void setProductsPromotionslist(List<ProductPromotionEntity> productsPromotionslist) {
        this.productsPromotionslist = productsPromotionslist;
    }
    
    
    
    
    public String getdateStarFormatted(){
        DateTimeFormatter dateStarFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateStarFormat.format(dateStar);
    }
    public String getdateCloseFormatted(){
        DateTimeFormatter dateCloseFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateCloseFormat.format(dateClose);
    }
}
