package com.sowmya.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sowmya.erp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}