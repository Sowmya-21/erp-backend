package com.sowmya.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sowmya.erp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}