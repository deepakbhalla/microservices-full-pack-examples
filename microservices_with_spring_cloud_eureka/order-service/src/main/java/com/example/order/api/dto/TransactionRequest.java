package com.example.order.api.dto;

import com.example.order.api.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order transaction request class.
 * 
 * @author Deepak Bhalla
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private Order order;
    private Payment payment;
}
