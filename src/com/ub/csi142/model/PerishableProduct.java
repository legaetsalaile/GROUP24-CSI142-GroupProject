package com.ub.csi142.model;

import java.io.PrintStream;
import java.time.LocalDate;

public class PerishableProduct extends Product {
   private LocalDate expiryDate;

   public PerishableProduct(String var1, String var2, int var3, double var4, LocalDate var6) {
      super(var1, var2, var3, var4);
      this.setExpiryDate(var6);
   }

   public LocalDate getExpiryDate() {
      return this.expiryDate;
   }

   public void setExpiryDate(LocalDate var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Expiry date cannot be null");
      } else {
         this.expiryDate = var1;
      }
   }

   public boolean isExpired() {
      return this.expiryDate.isBefore(LocalDate.now());
   }

   public String getProductType() {
      return "Perishable";
   }

   public boolean isPerishable() {
      return true;
   }

   public void display() {
      PrintStream var10000 = System.out;
      String var10001 = this.getName();
      var10000.println("Perishable Product: " + var10001);
      var10000 = System.out;
      var10001 = this.getProductID();
      var10000.println("Product ID: " + var10001);
      var10000 = System.out;
      int var6 = this.getQuantity();
      var10000.println("Quantity: " + var6);
      var10000 = System.out;
      double var7 = this.getPrice();
      var10000.println("Price: P" + var7);
      var10000 = System.out;
      String var8 = String.valueOf(this.expiryDate);
      var10000.println("Expiry Date: " + var8);
      System.out.println(this.isExpired() ? "Status: Expired" : "Status: Fresh");
   }
}
