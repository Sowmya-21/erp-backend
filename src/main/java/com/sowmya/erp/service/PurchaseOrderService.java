package com.sowmya.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sowmya.erp.exception.CustomException;
import com.sowmya.erp.model.OrderItem;
import com.sowmya.erp.model.Product;
import com.sowmya.erp.model.PurchaseOrder;
import com.sowmya.erp.model.Supplier;
import com.sowmya.erp.repository.ProductRepository;
import com.sowmya.erp.repository.PurchaseOrderRepository;
import com.sowmya.erp.repository.SupplierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {

    private final PurchaseOrderRepository repo;
    private final SupplierRepository supplierRepo;
    private final ProductRepository productRepo;

    public PurchaseOrder create(PurchaseOrder order) {

        // ✅ Fetch supplier from DB
        Supplier supplier = supplierRepo.findById(order.getSupplier().getId())
                .orElseThrow(() -> new CustomException("Supplier not found"));

        // ✅ Process items (VERY IMPORTANT)
        List<OrderItem> updatedItems = order.getItems().stream().map(item -> {

            Product product = productRepo.findById(item.getProduct().getId())
                    .orElseThrow(() -> new CustomException("Product not found"));

            item.setProduct(product); // attach real product

            return item;
        }).toList();

        order.setSupplier(supplier);
        order.setItems(updatedItems);
        order.setStatus("ORDERED");

        return repo.save(order);
    }

    public List<PurchaseOrder> getAll() {
        return repo.findAll();
    }
}