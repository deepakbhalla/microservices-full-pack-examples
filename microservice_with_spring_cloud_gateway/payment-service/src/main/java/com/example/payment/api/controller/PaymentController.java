package com.example.payment.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.api.entity.Payment;
import com.example.payment.api.service.PaymentService;

@RestController
@RequestMapping(value = "/payment/v1")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public Payment processPayment(@RequestBody Payment payment) {
        return service.processPayment(payment);
    }

    @GetMapping("{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) {
        return service.findPaymentHistoryByOrderId(orderId);
    }
}
