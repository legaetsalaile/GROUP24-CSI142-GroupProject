package com.ub.csi142.model;

public abstract class Product{
    private String name;
    private String productID;
    private int quantity;
    private int price;

// Constructor 

public Product(String name, String productID, int quantity, int price){
    this.name=name;
    this.productID=productID;
    this.quantity=quantity;
    this.price=price; 
}

//Geters 

public String getName(){
return name;
}

public String getProductID(){
    return productID;
}

public int getQuantity(){
    return quantity; 
}

public int getPrice(){
    return price;
}

//Setters

public void setName(String name){
    this.name=name;
}

public void setProductID(String productID){
    this.productID=productID;
}

public void setQuantity(int quantity){
    this.quantity=quantity;
}

public void setPrice(int price){
    this.price=price;
}

public double TotalValue(){
   return price * quantity;
}
public abstract void display();
}

