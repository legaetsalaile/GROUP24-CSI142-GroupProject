package com.ub.csi142.model;

 public class PerishableProduct extends Product {
    private String expiryDate;

//Constructor
public PerishableProduct(String name, String productID, int quantity, int price, String expiryDate){
    super(name, productID, quantity, price); 
    this.expiryDate=expiryDate;   
}

//getter
public String getExpiryDate(){
    return expiryDate;
}

//setters
public void setExpiryDate(String expiryDate){
    this.expiryDate=expiryDate;
}
@Override
public void display() {
    System.out.println("Perishable Product:" + getName());
    System.out.println("productID:" + getProductID());
    System.out.println("Quantity:" + getQuantity());
    System.out.println("Price:" + getPrice());
    System.out.println("Expiry Date:" + expiryDate);
}
}