package com.sowmya.erp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sowmya.erp.exception.CustomException;
import com.sowmya.erp.model.OrderItem;
import com.sowmya.erp.model.Product;
import com.sowmya.erp.model.PurchaseOrder;
import com.sowmya.erp.repository.ProductRepository;
import com.sowmya.erp.repository.PurchaseOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GRNService {

    private final PurchaseOrderRepository poRepo;
    private final ProductRepository productRepo;

    @Transactional
    public PurchaseOrder receiveOrder(Long purchaseOrderId) {

        PurchaseOrder order = poRepo.findById(purchaseOrderId)
                .orElseThrow(() -> new CustomException("Purchase order not found"));

        if (order.getStatus().equals("RECEIVED")) {
            throw new CustomException("Order already received");
        }

        // 🔥 Increase stock
        for (OrderItem item : order.getItems()) {
            Product product = productRepo.findById(item.getProduct().getId())
                    .orElseThrow(() -> new CustomException("Product not found"));

            product.setStock(product.getStock() + item.getQuantity());
            productRepo.save(product);
        }

        order.setStatus("RECEIVED");

        return poRepo.save(order);
    }
}