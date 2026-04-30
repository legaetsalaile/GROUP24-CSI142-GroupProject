package com.ub.csi142.model;

import java.io.PrintStream;
import java.time.LocalDate;

public class PerishableProduct extends Product {
   private LocalDate expiryDate;

   public PerishableProduct(String name, String id, int qty, double price , LocalDate expiryDate) {
      super(name, id, qty, price);
      this.setExpiryDate(expiryDate);
   }

   public LocalDate getExpiryDate() {
      return this.expiryDate;
   }

   public void setExpiryDate(LocalDate name) {
      if (name == null) {
         throw new IllegalArgumentException("Expiry date cannot be null");
      } else {
         this.expiryDate = name;
      }
   } 

   

   public boolean isExpired() {
      return this.expiryDate.isBefore(LocalDate.now());
   }

   @Override
   public String getProductType() {
      return "Perishable";
   }

   public boolean isPerishable() {
      return true;
   }
@Override
   public void display() {
     System.out.println("Name" + getName());  
     System.out.println("ID" + getProductID());  
     System.out.println("qty" + getQuantity());
     System.out.println("Price" + getPrice());
     System.out.println("Expiry" + expiryDate);
     System.out.println("Status" + (isExpired() ?"Expired" : "Fresh"));
   }
}
