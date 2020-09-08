package com.example.order.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Payment class.
 * 
 * @author Deepak Bhalla
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private double paymentId;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
}
