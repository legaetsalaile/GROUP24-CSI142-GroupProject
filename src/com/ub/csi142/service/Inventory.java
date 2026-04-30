package com.ub.csi142.service;

import com.ub.csi142.contracts.Reportable;
import com.ub.csi142.model.Product;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements Reportable {
   private final List<Product> products = new ArrayList<Product>();

   public Inventory() {
   }

   public void addProduct(Product var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Product cannot be null");
      } else {
         this.products.add(var1);
         System.out.println("Successfully added: " + var1.getName());
      }
   }

   public void searchProduct(String var1) {
      if (var1 != null && !var1.trim().isEmpty()) {
         boolean var2 = false;

         for(Product var4 : this.products) {
            if (var4.getName().equalsIgnoreCase(var1) || var4.getProductID().equalsIgnoreCase(var1)) {
               System.out.println("Product found:");
               var4.display();
               var2 = true;
               break;
            }
         }

         if (!var2) {
            System.out.println("Product not found: " + var1);
         }

      } else {
         System.out.println("Please provide a valid product name.");
      }
   }

   public Product findProductByName(String var1) {
      if (var1 == null) {
         return null;
      } else {
         for(Product var3 : this.products) {
            if (var3.getName().equalsIgnoreCase(var1) || var3.getProductID().equalsIgnoreCase(var1)) {
               return var3;
            }
         }

         return null;
      }
   }

   public void updateProduct(String var1, double var2) {
      Product var4 = this.findProductByName(var1);
      if (var4 == null) {
         System.out.println("Product not found: " + var1);
      } else {
         var4.setPrice(var2);
         PrintStream var10000 = System.out;
         String var10001 = var4.getName();
         var10000.println("Product updated: " + var10001 + " - P" + var4.getPrice());
      }
   }

   public void viewStock() {
      if (this.products.isEmpty()) {
         System.out.println("Inventory is empty.");
      } else {
         System.out.println("Current Stock:");

         for(Product var2 : this.products) {
            var2.display();
            System.out.println("---");
         }

      }
   }

   public void generateReport() {
      System.out.println("===============================");
      System.out.println("  Inventory Stock Report ");
      System.out.println("===============================");
      if (this.products.isEmpty()) {
         System.out.println("No products in the inventory.");
      } else {
         for(Product var2 : this.products) {
            PrintStream var10000 = System.out;
            String var10001 = var2.getName();
            var10000.println("Product: " + var10001 + " - Price: P" + var2.getPrice() + " - Quantity: " + var2.getQuantity());
         }
      }

      System.out.println("===============================");
   }

   public List<Product> getProducts() {
      return new ArrayList<Product>(this.products);
   }
}
