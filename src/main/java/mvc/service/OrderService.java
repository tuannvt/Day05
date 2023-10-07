package mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc.repository.OrderDetailsRepository;

@Service
public class OrderService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;


}
