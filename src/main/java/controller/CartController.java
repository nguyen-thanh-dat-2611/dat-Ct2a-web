package controller;

import component.Cart;
import entity.CustomerEntity;
import entity.OrderDetailsEntity;
import entity.OrderEntity;
import entity.ProductsEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.OrderDetailsRepository;
import repository.OrderRepository;
import repository.ProductRepository;

@Controller
@Scope(value = "session")
public class CartController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    Cart cart;
    
    @Autowired
    OrderRepository orderRepo;
    
    @Autowired
    OrderDetailsRepository orderDetailsRepo;
    
    @Autowired
    JavaMailSender javaMailSender;
    
    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
    public String addNewItem(@PathVariable(value = "id") int id, Model model) {
        ProductsEntity products = (ProductsEntity) productRepo.findById(id);
        cart.addItem(products);

        model.addAttribute("cart", cart);

        return "cart";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String removeCarts(@PathVariable(value = "id") int id, Model model) {
        ProductsEntity products = (ProductsEntity) productRepo.findById(id);
        cart.removeItem(products);
        model.addAttribute("cart", cart);
        return "cart";
    }
    
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String updateQuantity(Model model,@RequestParam(name= "id")int id,
            @RequestParam(name= "quantity")int quantity, ProductsEntity products){
       List<OrderDetailsEntity> orderDetailsList = cart.getOrderDetailsList();
       for(int i= 0; i<orderDetailsList.size();i++){
          if(orderDetailsList.get(i).getProducts().getId() == products.getId()){
              OrderDetailsEntity orderDetails = orderDetailsList.get(i);
              orderDetails.setQuantity(quantity);
              orderDetailsList.set(i, orderDetails);
              cart.setOrderDetailsList(orderDetailsList);
          }
        }
        model.addAttribute("cart", cart);
        return "cart";
    }
    
    @RequestMapping(value = "/addNewOrder1",method = RequestMethod.GET)
      public String showNewOrder(Model model){
          
       OrderEntity order = new OrderEntity();
       OrderDetailsEntity orderDetails = new OrderDetailsEntity();
        model.addAttribute("order", order);
        model.addAttribute("orderDetails", orderDetails);
        return "addNewOrder1";
      }
      
    @RequestMapping(value = "/addNewOrder",method = RequestMethod.POST)
      public String saveNewOrder(OrderEntity orders,Model model){
          CustomerEntity customer = new CustomerEntity();
          orders.setDateOrder(LocalDate.now());
          
          OrderEntity newOrder = orderRepo.save(orders);
          
          List<OrderDetailsEntity> orderDetailList = cart.getOrderDetailsList();
          for(OrderDetailsEntity orderDetails : orderDetailList){
            orderDetails.setOrders(newOrder);
            orderDetailsRepo.save(orderDetails);
        } 
          
        SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(newOrder.getEmail());
            msg.setSubject("Airline");
            msg.setText("Congratulations! You have successfully registered for an account. "
                    + "Code Orders: " + newOrder.getEmail());
            javaMailSender.send(msg);

          return "redirect:/";
      }

}
