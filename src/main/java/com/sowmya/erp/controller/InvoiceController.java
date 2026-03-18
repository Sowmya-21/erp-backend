package com.sowmya.erp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowmya.erp.model.Invoice;
import com.sowmya.erp.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceRepository repo;

    @GetMapping
    public List<Invoice> getAll() {
        return repo.findAll();
    }
}