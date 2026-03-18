package com.sowmya.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sowmya.erp.dto.SalesOrderRequest;
import com.sowmya.erp.exception.CustomException;
import com.sowmya.erp.model.Customer;
import com.sowmya.erp.model.OrderItem;
import com.sowmya.erp.model.Product;
import com.sowmya.erp.model.SalesOrder;
import com.sowmya.erp.repository.CustomerRepository;
import com.sowmya.erp.repository.ProductRepository;
import com.sowmya.erp.repository.SalesOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalesOrderService {

    private final SalesOrderRepository repo;
    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;
    private final InvoiceService invoiceService;

    @Transactional
public SalesOrder create(SalesOrderRequest request) {

    Customer customer = customerRepo.findById(request.getCustomerId())
            .orElseThrow(() -> new CustomException("Customer not found"));

    final double[] total = {0};

    List<OrderItem> items = request.getItems().stream().map(reqItem -> {

        Product product = productRepo.findById(reqItem.getProductId())
                .orElseThrow(() -> new CustomException("Product not found"));

        if (product.getStock() < reqItem.getQuantity()) {
            throw new CustomException("Insufficient stock for product: " + product.getName());
        }

        product.setStock(product.getStock() - reqItem.getQuantity());
        productRepo.save(product);

        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(reqItem.getQuantity());

        total[0] += product.getPrice() * reqItem.getQuantity();

        return item;
    }).toList();

    SalesOrder order = new SalesOrder();
    order.setCustomer(customer);
    order.setItems(items);
    order.setTotalAmount(total[0]);

    SalesOrder savedOrder = repo.save(order);

    invoiceService.generateInvoice(savedOrder);

    return savedOrder;
}

    public List<SalesOrder> getAll() {
        return repo.findAll();
    }
}