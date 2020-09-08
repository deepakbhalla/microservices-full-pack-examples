package com.example.order.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order entity class.
 * 
 * @author Deepak Bhalla
 *
 */
@Entity // Java persistence annotation to specify this class as an Entity
@Table(name = "ORDER_TB") // Java persistence annotation to specify table name for this entity
@Data // Lombok annotation to add setters and getters of class arguments
@AllArgsConstructor // Lombok annotation to add all argument constructor
@NoArgsConstructor // Lombok annotation to add no argument constructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private double price;
}
