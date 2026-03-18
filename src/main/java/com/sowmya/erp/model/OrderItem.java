package com.sowmya.erp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MANY items → ONE product
    @ManyToOne
    private Product product;

    // MANY items → ONE order
    @ManyToOne
    @JsonBackReference
    private SalesOrder order;

    private Integer quantity;
}