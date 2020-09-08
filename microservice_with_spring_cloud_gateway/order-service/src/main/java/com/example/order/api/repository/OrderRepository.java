package com.example.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.order.api.entity.Order;

/**
 * Order Repository.
 * 
 * @author Deepak Bhalla
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
