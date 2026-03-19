package iuh.fit.singleton_demo.service;

import org.springframework.stereotype.Service;
import iuh.fit.singleton_demo.singleton.AppLogger;

@Service
public class OrderService {
    public String createOrder(String orderName) {
        AppLogger.getInstance().log("Creating order: " + orderName);
        return "Order created: " + orderName;
    }
}
