package com.ub.csi142.model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
   private final List<SaleItem> items = new ArrayList<SaleItem>();

   public Sale() {
   }

   public void addSaleItem(SaleItem var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Sale item cannot be null");
      } else {
         this.items.add(var1);
      }
   }

   public double calculateTotal() {
      double var1 = (double)0.0F;

      for(SaleItem var4 : this.items) {
         var1 += var4.getSubtotal();
      }

      return var1;
   }

   public void printReceipt() {
      System.out.println("\n--- Receipt ---");

      for(SaleItem var2 : this.items) {
         System.out.println(var2);
      }

      System.out.println("Total: P" + this.calculateTotal());
   }

   public double getTotalAmount() {
      return this.calculateTotal();
   }

   public String toString() {
      double var10000 = this.calculateTotal();
      return "Sale total: P" + var10000 + " (" + this.items.size() + " item(s))";
   }
}
