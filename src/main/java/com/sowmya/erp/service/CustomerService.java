package com.sowmya.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sowmya.erp.model.Customer;
import com.sowmya.erp.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repo;

    public Customer create(Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }
}