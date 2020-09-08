package com.example.order.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.api.dto.Payment;
import com.example.order.api.dto.TransactionRequest;
import com.example.order.api.dto.TransactionResponse;
import com.example.order.api.entity.Order;
import com.example.order.api.repository.OrderRepository;

@Service
public class OrderService {

    private static final String SUCCESS = "success";
    private static final String PAYMENT_GATEWAY_API_PATH = "http://localhost:9081/payment/v1";

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Saves order details and call payment gateway to process the payement.
     * 
     * @param request
     *            - TransactionRequest
     * @return TransactionResponse
     */
    public TransactionResponse saveOrder(TransactionRequest request) {

        Order order = request.getOrder();
        // Place an order
        orderRepository.save(order);

        // Payment processing
        Payment payment = request.getPayment();
        payment.setAmount(order.getPrice());
        payment.setOrderId(order.getId());

        // Calling Payment Service which is hosted on another server
        Payment response = restTemplate.postForObject(PAYMENT_GATEWAY_API_PATH, payment, Payment.class);

        String message = SUCCESS.equalsIgnoreCase(response.getPaymentStatus())
                ? "Payment has been received and order placed successfully"
                : "Order placed successfully however payment has been failed";

        return new TransactionResponse(order, response.getTransactionId(), response.getAmount(), message,
                response.getPaymentStatus());
    }
}
