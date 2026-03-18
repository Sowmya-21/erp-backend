package com.sowmya.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sowmya.erp.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}