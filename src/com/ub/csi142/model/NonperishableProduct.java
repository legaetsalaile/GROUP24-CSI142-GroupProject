package com.ub.csi142.model;

public class NonPerishableProduct extends Product {
    private int shelfLife; // in months

    public NonPerishableProduct(String name, String productID, int quantity, double price, int shelfLife) {
        super(name, productID, quantity, price);
        setShelfLife(shelfLife);
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        if (shelfLife < 0) {
            throw new IllegalArgumentException("Shelf life cannot be negative");
        }
        this.shelfLife = shelfLife;
    }

    @Override
    public String getProductType() {
        return "Non-Perishable";
    }

    @Override
    public boolean isPerishable() {
        return false;
    }

    @Override
    public void display() {
        System.out.println("Non-Perishable Product: " + getName());
        System.out.println("Product ID: " + getProductID());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Price: P" + getPrice());
        System.out.println("Shelf Life: " + shelfLife + " months");
    }
}
