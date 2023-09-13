package repository;

import entity.OrdersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends CrudRepository<OrdersEntity,Integer> {
    @Query(value = "select MONTH(orderDate) as Month from orders where orderID=9")
    List<OrdersEntity> findByOrderDate(LocalDate month);
}
