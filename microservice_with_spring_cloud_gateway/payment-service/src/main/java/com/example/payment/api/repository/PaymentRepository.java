package com.example.payment.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.payment.api.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findByOrderId(int orderId);
}
