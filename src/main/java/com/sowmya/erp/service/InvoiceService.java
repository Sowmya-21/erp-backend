package com.sowmya.erp.service;

import org.springframework.stereotype.Service;

import com.sowmya.erp.model.Invoice;
import com.sowmya.erp.model.SalesOrder;
import com.sowmya.erp.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository repo;

    public Invoice generateInvoice(SalesOrder order) {

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setAmount(order.getTotalAmount());
        invoice.setStatus("UNPAID");

        return repo.save(invoice);
    }
}