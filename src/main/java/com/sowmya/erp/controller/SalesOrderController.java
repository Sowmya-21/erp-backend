package com.sowmya.erp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowmya.erp.dto.SalesOrderRequest;
import com.sowmya.erp.model.SalesOrder;
import com.sowmya.erp.service.SalesOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class SalesOrderController {

    private final SalesOrderService service;

   @PostMapping
public SalesOrder create(@RequestBody SalesOrderRequest request) {
    return service.create(request);
}

    @GetMapping
    public List<SalesOrder> getAll() {
        return service.getAll();
    }
}