package com.ub.csi142.model;

public class SaleItem {
   private Product product;
   private int quantitySold;

   public SaleItem(Product var1, int var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("Product cannot be null");
      } else if (var2 <= 0) {
         throw new IllegalArgumentException("Quantity must be greater than zero");
      } else {
         this.product = var1;
         this.quantitySold = var2;
      }
   }

   public Product getProduct() {
      return this.product;
   }

   public int getQuantitySold() {
      return this.quantitySold;
   }

   public double getSubtotal() {
      return this.product.getPrice() * (double)this.quantitySold;
   }

   public String toString() {
      String var10000 = this.product.getName();
      return var10000 + " x" + this.quantitySold + " - P" + this.getSubtotal();
   }
}
