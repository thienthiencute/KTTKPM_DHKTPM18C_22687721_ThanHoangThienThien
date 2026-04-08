package com.example.paymentservice.controller;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest request) {
        paymentService.processPayment(request.getOrderId(), request.getMethod());
        return ResponseEntity.ok("Payment success - Order #" + request.getOrderId() + " paid");
    }
}
class PaymentRequest {
    private Long orderId;
    private String method; // COD, Banking
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
}

