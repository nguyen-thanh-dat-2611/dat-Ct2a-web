

package repository;

import entity.OrderDetailsEntity;
import entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity, Integer> {
     OrderEntity findById(int id);
     
   
}
