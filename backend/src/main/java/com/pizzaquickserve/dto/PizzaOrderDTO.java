package com.pizzaquickserve.dto;

import java.time.LocalDateTime;

public class PizzaOrderDTO {
    private Long id;
    private String customerName;
    private Long pizzaId;
    private Long customerId;  // Added customerId field
    private LocalDateTime orderDateTime;
    private LocalDateTime deliveryDateTime;
    private int quantity;

    // Default constructor
    public PizzaOrderDTO() {
    }

    // Constructor matching the query in the repository
    public PizzaOrderDTO(Long id, String customerName, Long pizzaId, LocalDateTime orderDateTime, LocalDateTime deliveryDateTime, int quantity) {
        this.id = id;
        this.customerName = customerName;
        this.pizzaId = pizzaId;
        this.orderDateTime = orderDateTime;
        this.deliveryDateTime = deliveryDateTime;
        this.quantity = quantity;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public LocalDateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
