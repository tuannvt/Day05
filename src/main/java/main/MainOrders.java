package main;

import configuration.JPAConfig;
import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.OrderDetailsRepository;
import repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

public class MainOrders {
    static ApplicationContext context =new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");
    static OrderDetailsRepository orderDetailsRepository = (OrderDetailsRepository) context.getBean("orderDetailsRepository");

    public static void main(String[] args) {
//        createNewOrdersWhichOrderDetails();
//        createNewOrder();
//        readOrders();
//        readOrderDetails();
        findById(1);

    }
    private static OrdersEntity createNewOrder(){
        OrdersEntity ordersEntity=new OrdersEntity();
        ordersEntity.setOrderDate(LocalDate.now());
        ordersEntity.setCustomerName("Roger");
        ordersEntity.setCustomerAddress("USA");
        return ordersEntity;
    }
    private static OrderDetailsEntity createNewOrderDetailsEntity(){
        OrderDetailsEntity orderDetailsEntity=new OrderDetailsEntity();
        orderDetailsEntity.setProductName("AA");
        orderDetailsEntity.setQuantity(10);
        orderDetailsEntity.setUnitPrice(10.5);
        return orderDetailsEntity;
    }
    public static void createNewOrders(){
        OrdersEntity ordersEntity=new OrdersEntity();
        ordersEntity.setId(1);
        OrderDetailsEntity orderDetailsEntity=createNewOrderDetailsEntity();
        orderDetailsEntity.setOrders(ordersEntity);
        orderDetailsRepository.save(orderDetailsEntity);
    }
    public static void createNewOrdersWhichOrderDetails() {
        OrdersEntity ordersEntity = createNewOrder();
        orderRepository.save(ordersEntity);
        OrderDetailsEntity orderDetailsEntity = createNewOrderDetailsEntity();
        orderDetailsEntity.setOrders(ordersEntity);
        orderDetailsRepository.save(orderDetailsEntity);
    }
    public static void readOrders(){
        List<OrdersEntity>ordersEntityList=( List<OrdersEntity>)orderRepository.findAll();
        System.out.println("Foud "+ordersEntityList.size());
        System.out.println("they are: ");
        for (OrdersEntity orders:ordersEntityList){
            System.out.println(orders.toString());
        }
    }
    public static void readOrderDetails(){
        List<OrderDetailsEntity>orderDetailsEntityList=( List<OrderDetailsEntity>)orderDetailsRepository.findAll();
        System.out.println("Foud "+orderDetailsEntityList.size());
        System.out.println("they are: ");
        for (OrderDetailsEntity orderDetails:orderDetailsEntityList){
            System.out.println(orderDetails.toString());
        }
    }
    public static void findById(int id){
        OrdersEntity ordersEntity=orderRepository.findById(id).get();
        System.out.println(ordersEntity.toString());
    }
    public static void findByOrderDate(){

    }
}
