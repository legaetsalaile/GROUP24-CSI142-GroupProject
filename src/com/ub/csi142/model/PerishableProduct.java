package com.ub.csi142.model;

import java.time.LocalDate;

public class PerishableProduct extends Product {
    private LocalDate expiryDate;

    public PerishableProduct(String name, String productID, int quantity, double price, LocalDate expiryDate) {
        super(name, productID, quantity, price);
        setExpiryDate(expiryDate);
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        if (expiryDate == null) {
            throw new IllegalArgumentException("Expiry date cannot be null");
        }
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public String getProductType() {
        return "Perishable";
    }

    @Override
    public boolean isPerishable() {
        return true;
    }

    @Override
    public void display() {
        System.out.println("Perishable Product: " + getName());
        System.out.println("Product ID: " + getProductID());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Price: P" + getPrice());
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println(isExpired() ? "Status: Expired" : "Status: Fresh");
    }
}
