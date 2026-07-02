package com.exercise3.orderservice.model;

import java.util.List;

public class Order {

    private Long orderId;
    private String customerName;
    private List<Long> productIds;

    public Order() {
    }

    public Order(Long orderId, String customerName, List<Long> productIds) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productIds = productIds;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
