
package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table (name = " payments ")
public class PaymentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int ID;
    
    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity order;
    
    @ManyToOne
    @JoinColumn(name = "creditCradId")
    private CreditcradEntity creditcrad;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    
    private double price;
    private String method;

    public PaymentsEntity(int ID, OrderEntity order, CreditcradEntity creditcrad, LocalDate date, String amount, String method) {
        this.ID = ID;
        this.order = order;
        this.creditcrad = creditcrad;
        this.date = date;
        this.price = price;
        this.method = method;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public CreditcradEntity getCreditcrad() {
        return creditcrad;
    }

    public void setCreditcrad(CreditcradEntity creditcrad) {
        this.creditcrad = creditcrad;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
     
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    
    
    
    public String getdateFormatted(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateFormat.format(date);
    }
}
