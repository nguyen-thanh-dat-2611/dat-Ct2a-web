
package repository;

import entity.ProductsEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductsEntity, Integer>{
    ProductsEntity findById(int id);
    
    @Query(value="select * from products where categoryid = ?1", nativeQuery = true)
    List<ProductsEntity> findByCategoryid(int id);
    
    @Query(value ="select * from products order by productDate desc limit 4", nativeQuery = true)
    List<ProductsEntity> findByNewProduct();
    
    @Query(value ="select * from products where productId in(select productId " +
           "from orderdetails " +
           "group by productId " +
           "order by sum(quantity) desc) limit 4", nativeQuery = true)
    List<ProductsEntity> getSelling();
   
    ProductsEntity findByName(String name);
    List<ProductsEntity>findByNameLike(String name);
}

