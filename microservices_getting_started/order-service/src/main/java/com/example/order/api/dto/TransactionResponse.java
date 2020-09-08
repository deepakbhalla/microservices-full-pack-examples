package com.example.order.api.dto;

import com.example.order.api.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order transaction response class.
 * 
 * @author Deepak Bhalla
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private Order order;
    private String transactionId;
    private double amount;
    private String message;
    private String status;
}
