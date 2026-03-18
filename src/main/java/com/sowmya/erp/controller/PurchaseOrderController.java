package com.sowmya.erp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowmya.erp.model.PurchaseOrder;
import com.sowmya.erp.service.PurchaseOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/purchase-orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    @PostMapping
    public PurchaseOrder create(@RequestBody PurchaseOrder order) {
        return service.create(order);
    }

    @GetMapping
    public List<PurchaseOrder> getAll() {
        return service.getAll();
    }
}