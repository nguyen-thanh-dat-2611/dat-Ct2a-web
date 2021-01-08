package controller;

import entity.CategoryEntity;
import entity.ProductsEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.CategoryRepository;
import repository.ProductRepository;



@Controller
public class HomeController {
    @Autowired
    ProductRepository productRepo;
    @Autowired
    CategoryRepository categoryRepo;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAllCity(Model model) {
        List<CategoryEntity> categoryList = (List<CategoryEntity>) categoryRepo.findAll();
        List<ProductsEntity> productList = (List<ProductsEntity>) productRepo.findAll();
        List<ProductsEntity> newProduct = (List<ProductsEntity>) productRepo.findByNewProduct();
        List<ProductsEntity> sellingList = (List<ProductsEntity>) productRepo.getSelling();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("productList", productList); 
        model.addAttribute("newProduct", newProduct);
        model.addAttribute("sellingList", sellingList);
        return "home";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchProductProcess(@RequestParam(name = "searchText") String searchText, Model model) {
        String searchText1 = "%" + searchText + "%";
        List<ProductsEntity> productList = productRepo.findByNameLike(searchText1);
        List<CategoryEntity> categoryList = (List<CategoryEntity>) categoryRepo.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("productList", productList);
        model.addAttribute("searchText", searchText);
        return "home";
    }
    
    @RequestMapping(value="/productListByCategory/{id}", method = RequestMethod.GET)
    public String getProductByCatrgoryId(@PathVariable (value="id") int id,Model model) {
       List<CategoryEntity> categoryList = (List<CategoryEntity>) categoryRepo.findAll();
       model.addAttribute("categoryList", categoryList);
	List<ProductsEntity> productList = productRepo.findByCategoryid(id);
        model.addAttribute("productList", productList);
        
        return "productList";
    }
    @RequestMapping(value ="/productList",method = RequestMethod.GET)
    public String listProducts(Model model){
        List<ProductsEntity> productList =(List<ProductsEntity>) productRepo.findAll();
        model.addAttribute("productList", productList);
        return "productList";
    }
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String showProductDetails(@PathVariable(value = "id") int id, Model model) {
        ProductsEntity products= (ProductsEntity) productRepo.findById(id);
        model.addAttribute("products", products); 

        return "detail";
    }
    @RequestMapping(value = "/contact/", method = RequestMethod.GET)
    public String showContact(@PathVariable(value = "id") int id, Model model) {
        List<ProductsEntity> productList = (List<ProductsEntity>) productRepo.findAll();
        model.addAttribute("productList", productList); 

        return "contact";
    }

}