package com.ub.csi142.model;

public class NonperishableProduct extends Product {
   private int shelfLife;

   public NonperishableProduct(String var1, String var2, int var3, double var4, int var6) {
      super(var1, var2, var3, var4);
      this.setShelfLife(var6);
   }

   public int getShelfLife() {
      return this.shelfLife;
   }

   public void setShelfLife(int var1) {
      if (var1 < 0) {
         throw new IllegalArgumentException("Shelf life cannot be negative");
      } else {
         this.shelfLife = var1;
      }
   }

   public String getProductType() {
      return "Non-Perishable";
   }

   public boolean isPerishable() {
      return false;
   }

   public void display() {
      System.out.println("Non-Perishable Product: " + this.getName());
      System.out.println("Product ID: " + this.getProductID());
      System.out.println("Quantity: " + this.getQuantity());
      System.out.println("Price: P" + this.getPrice());
      System.out.println("Shelf Life: " + this.shelfLife + " months");
   }
}
