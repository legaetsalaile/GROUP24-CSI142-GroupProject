package com.ub.csi142.model;

public class NonperishableProduct{
    public NonPerishableProduct(String name, String productID, Int quantity,Double price,){
        super(name,productID,quantity,price,expiryDate);
    }

    @Override
    public boolean isperishable(){    
    return false;
}

    @Override
    System.out.println("Non-perishable Product:"+ getName());
    System.out.println("ProductID:"+ getProductID());
    System.out.println("Quantity:"+ getquantity());
    System.out.println("Price:"getprice());
    
}