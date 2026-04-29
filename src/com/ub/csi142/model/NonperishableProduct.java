package com.ub.csi142.model;

public class NonperishableProduct extends Product{
    private int shelfLife; // in months
    public NonPerishableProduct(String name, String productID, int quantity, double price, String expiryDate){
        super(name, productID, quantity, price, expiryDate);
        this.shelfLife = shelfLife;
    }
    public int getShelfLife(){
        return shelfLife;
    }

    @Override
    public boolean isperishable(){    
    return false;
    }

    @Override
    public String toString(){
        return "Non-perishable Product: " + getName() + ", ID: " + getProductID() + ", Quantity: " + getQuantity() + ", Price: P" + getPrice() + ", Shelf Life: " + shelfLife + " months";
    }
    
}