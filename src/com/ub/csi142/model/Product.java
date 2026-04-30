package com.ub.csi142.model;

public abstract class Product {
    private String name;
    private String productID;
    private int quantity;
    private double price;

    public Product(String name, String productID, int quantity, double price) {
        setName(name);
        setProductID(productID);
        setQuantity(quantity);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Please enter the name");
        }
        this.name = name.trim();
    }

    public void setProductID(String productID) {
        if (productID == null || productID.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        this.productID = productID.trim();
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void restock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Restock should be greater than 0");
        }
        this.quantity += amount;
    }

    public void reduceStock(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Quantity should be greater than 0");
        }
        if (amount > quantity) {
            throw new IllegalArgumentException("Not enough stock");
        }
        this.quantity -= amount;
    }

    public abstract String getProductType();

    public abstract void display();

    public abstract boolean isPerishable();
}
