package com.sowmya.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sowmya.erp.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}