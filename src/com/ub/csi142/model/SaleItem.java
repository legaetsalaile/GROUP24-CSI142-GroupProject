package com.ub.csi142.model;

public class SaleItem {
    private String name;
    private double price;
    private int quantity;


    public SaleItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    
    public SaleItem() {
        this.name = "Unknown";
        this.price = 0.0;
        this.quantity = 0;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    public double getTotalPrice() {
        return price * quantity;
    }

    public void displayItem() {
        System.out.println("Item Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + getTotalPrice());
    }
}