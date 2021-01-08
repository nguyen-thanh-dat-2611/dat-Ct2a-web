package component;

import entity.OrderDetailsEntity;
import entity.ProductsEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session")
public class Cart {
    private List<OrderDetailsEntity> orderDetailsList;

    public Cart() {
        orderDetailsList = new ArrayList<OrderDetailsEntity>();
    }
    public void addItem(ProductsEntity products){
        boolean t=false;
        for (int i=0; i<orderDetailsList.size(); i++){
            if (orderDetailsList.get(i).getProducts().getId()==products.getId()){
                OrderDetailsEntity orderDetails = orderDetailsList.get(i);
                orderDetails.setQuantity(orderDetails.getQuantity() +1);
                orderDetailsList.set(i,orderDetails);
                t=true;
            }
        }
        if(!t){
            OrderDetailsEntity orderDetails = new OrderDetailsEntity();
            orderDetails.setProducts(products);
            orderDetails.setQuantity(1);
            orderDetails.setPrice(products.getPrice());
            orderDetailsList.add(orderDetails);
        }
    }
    
    public void removeItem(ProductsEntity products) {
        for (int i = 0; i < orderDetailsList.size(); i++) {
            if (orderDetailsList.get(i).getProducts().getId() == products.getId()) {
                orderDetailsList.remove(i);
            }
        }
    }


    public List<OrderDetailsEntity> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetailsEntity> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
    public int getCount(){
        return orderDetailsList.size();
    }
    public double getTotal(){
        double sum = 0;
        for(OrderDetailsEntity orderDeatails:orderDetailsList){
            sum = sum+ orderDeatails.getTotal();
            
        }
        return sum;
    }
 
}
