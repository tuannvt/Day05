package mvc.main;

import java.util.Optional;
import mvc.configuration.JPAConfig;
import mvc.entity.OrderDetailsEntity;
import mvc.entity.OrdersEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import mvc.repository.OrderDetailsRepository;
import mvc.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;


public class MainOrders {
    static ApplicationContext context =new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");
    static OrderDetailsRepository orderDetailsRepository = (OrderDetailsRepository) context.getBean("orderDetailsRepository");
    public static void main(String[] args) {
//        readOrderDetails();
//        findByIdOrderDetail(2);
//        totalOrderDetail();
        searchOrder("Ng");
    }
    public static void readOrderDetails(){
        List<OrderDetailsEntity>orderDetailsEntityList=(List<OrderDetailsEntity>)orderDetailsRepository.findAll();
        for (OrderDetailsEntity orderDetails:orderDetailsEntityList){
            System.out.println(orderDetails.toString());
        }
    }
    public static void findByIdOrderDetail(int id){
       Optional<OrderDetailsEntity> orderDetails=orderDetailsRepository.findById(id);
           System.out.println(orderDetails.toString());
    }
    public static void totalOrderDetail(){
        double total=0;
        List<OrderDetailsEntity>orderDetailsEntityList=(List<OrderDetailsEntity>)orderDetailsRepository.findAll();
        for (OrderDetailsEntity orderDetails:orderDetailsEntityList){
            total=orderDetails.getQuantity()*orderDetails.getUnitPrice();
            if (total>=1000){
                System.out.println(orderDetails.toString());
            }
        }
    }
    public static void searchOrder(String customerName){
        List<OrdersEntity>list=orderRepository.findByCustomerNameContaining(customerName);
        for (OrdersEntity orders:list){
            System.out.println(orders.toString());
        }
    }
}
