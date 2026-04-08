package com.example.paymentservice.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class PaymentService {
    @Value("${service.order}")
    private String ORDER_SERVICE;
    private final RestTemplate restTemplate = new RestTemplate();
    public void processPayment(Long orderId, String method) {
        // Update order status PAID
        String url = ORDER_SERVICE + "/" + orderId + "/status?status=PAID";
        restTemplate.put(url, null);
        // Notification
        System.out.println("🔔 User đã đặt đơn #" + orderId + " thành công! Method: " + method);
    }
}

