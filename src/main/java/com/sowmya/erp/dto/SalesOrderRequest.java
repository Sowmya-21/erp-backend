package com.sowmya.erp.dto;

import java.util.List;

import lombok.Data;

@Data
public class SalesOrderRequest {
    private Long customerId;
    private List<OrderItemRequest> items;
}