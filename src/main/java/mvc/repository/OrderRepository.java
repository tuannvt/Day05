package mvc.repository;

import java.util.List;
import mvc.entity.OrdersEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrdersEntity,Integer> {
  List<OrdersEntity> findByCustomerNameContaining(String customerName);
}
