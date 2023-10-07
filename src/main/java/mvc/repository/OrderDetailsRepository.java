package mvc.repository;

import mvc.entity.OrderDetailsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity,Integer> {
    List<OrderDetailsEntity> findByProductNameContaining(String productName);

}
