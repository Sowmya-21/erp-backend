package com.sowmya.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sowmya.erp.model.Product;
import com.sowmya.erp.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    public Product create(Product product) {
        return repo.save(product);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }
}