/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String categoryname;
    
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    List<ProductsEntity> productList;

    public CategoryEntity() {
    }

    public CategoryEntity(int id, String categoryname, List<ProductsEntity> productList) {
        this.id = id;
        this.categoryname = categoryname;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public List<ProductsEntity> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductsEntity> productList) {
        this.productList = productList;
    }

    
     
}
