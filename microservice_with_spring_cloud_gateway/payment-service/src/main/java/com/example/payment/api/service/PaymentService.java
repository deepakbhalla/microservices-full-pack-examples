package com.example.payment.api.service;

import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.payment.api.entity.Payment;
import com.example.payment.api.repository.PaymentRepository;

@Service
public class PaymentService {

    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {

        payment.setPaymentStatus(paymentGatewayCall() ? SUCCESS : FAILED);
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    /*
     * Mock method to process payment and return success or failure (true/false). In
     * real time this should be any payment gateway.
     */
    private boolean paymentGatewayCall() {
        return new Random().nextBoolean() ? true : false;
    }

    public Payment findPaymentHistoryByOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
