package com.example.order.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.api.dto.TransactionRequest;
import com.example.order.api.dto.TransactionResponse;
import com.example.order.api.service.OrderService;

@RestController
@RequestMapping(value = "/order/v1")
public class OrderController {

    @Autowired
    public OrderService orderService;

    /**
     * Place an order.
     * 
     * @param request - TransactionRequest
     * @return TransactionResponse
     */
    @PostMapping
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {

        return orderService.saveOrder(request);
    }
}
