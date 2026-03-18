package com.sowmya.erp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowmya.erp.model.Supplier;
import com.sowmya.erp.repository.SupplierRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierRepository repo;

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return repo.save(supplier);
    }

    @GetMapping
    public List<Supplier> getAll() {
        return repo.findAll();
    }
}