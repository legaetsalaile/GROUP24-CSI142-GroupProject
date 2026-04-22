package com.ub.csi142.model;

import java.time.LocalDate;

 public class PerishableProduct extends Product {
    private LocalDate expiryDate;

//Constructor
public PerishableProduct(String name, String productID, int quantity, double price, LocalDate expiryDate){
    super(name, productID, quantity, price); 
    setExpiryDate(expiryDate);
}

//getter
public LocalDate getExpiryDate(){
    return expiryDate;
}

//setters
public void setExpiryDate(LocalDate expiryDate){
    if (expiryDate ==null){
        throw new IllegalArgumentException("date cannot be null");
    }
    this.expiryDate=expiryDate;
}
public boolean isExpired(){
    return expiryDate.isBefore(LocalDate.now());
}
@Override
public String getProductType(){
    return"Perishable";
}

@Override
public void display() {
    System.out.println("Perishable Product:" + getName());
    System.out.println("productID:" + getProductID());
    System.out.println("Quantity:" + getQuantity());
    System.out.println("Price:" + getPrice());
    System.out.println("Expiry Date:" + expiryDate);

if (isExpired()){
    System.out.println("Status Expired");
    
}else{
    System.out.println("Status  Fresh");
}
}
 }