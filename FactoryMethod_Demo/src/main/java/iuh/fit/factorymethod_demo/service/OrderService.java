package iuh.fit.factorymethod_demo.service;

import iuh.fit.factorymethod_demo.Order;
import iuh.fit.factorymethod_demo.OrderFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public String createOrder(String type) {
        Order order = OrderFactory.createOrder(type);

        // Log hashcode để thấy object khác nhau
        System.out.println(type + " Order hashCode: " + order.hashCode());

        return order.prepare();
    }
}
