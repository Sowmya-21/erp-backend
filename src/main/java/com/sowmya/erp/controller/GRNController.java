package com.sowmya.erp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowmya.erp.model.PurchaseOrder;
import com.sowmya.erp.service.GRNService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/grns")
@RequiredArgsConstructor
public class GRNController {

    private final GRNService service;

    @PostMapping("/{id}")
    public PurchaseOrder receive(@PathVariable Long id) {
        return service.receiveOrder(id);
    }
}