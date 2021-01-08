
package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "orderdetails")
public class OrderDetailsEntity {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
  @ManyToOne
    @JoinColumn(name = "orderId")
    private OrderEntity orders;
  @ManyToOne
    @JoinColumn(name = "productID")
  private ProductsEntity products;
  
  private int quantity;
  private double price;

    public OrderDetailsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderEntity getOrders() {
        return orders;
    }

    public void setOrders(OrderEntity orders) {
        this.orders = orders;
    }

    

    public ProductsEntity getProducts() {
        return products;
    }

    public void setProducts(ProductsEntity products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal(){
        double total = products.getPrice() * quantity;
        return total;
    }
}
