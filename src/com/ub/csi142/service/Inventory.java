package com.ub.csi142.service;

import com.ub.csi142.contracts.Reportable;
import com.ub.csi142.model.Product;
import com.ub.csi142.model.Sale;
import com.ub.csi142.model.SaleItem;
import com.ub.csi142.util.InputHelper;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class SalesManager implements Reportable {
   private final List<Sale> sales = new ArrayList<Sale>();

   public SalesManager() {
   }

   public void recordSale(Inventory var1, InputHelper var2) {
      if (var1 != null && var2 != null) {
         if (var1.getProducts().isEmpty()) {
            System.out.println("No products available to sell.");
         } else {
            String var3 = var2.getString("Enter product name or ID: ");
            Product var4 = var1.findProductByName(var3);
            if (var4 == null) {
               System.out.println("Product not found: " + var3);
            } else {
               int var5 = var2.getInt("Enter quantity to sell: ");
               if (var5 <= 0) {
                  System.out.println("Quantity must be greater than zero.");
               } else if (var5 > var4.getQuantity()) {
                  System.out.println("Not enough stock. Available: " + var4.getQuantity());
               } else {
                  var4.reduceStock(var5);
                  Sale var6 = new Sale();
                  var6.addSaleItem(new SaleItem(var4, var5));
                  this.sales.add(var6);
                  var6.printReceipt();
               }
            }
         }
      } else {
         System.out.println("Sales cannot be recorded because inventory or input helper is missing.");
      }
   }

   public void viewSalesReport() {
      if (this.sales.isEmpty()) {
         System.out.println("No sales recorded.");
      } else {
         System.out.println("View Sales Report");

         for(Sale var2 : this.sales) {
            System.out.println(var2);
            System.out.println("------------------------------");
         }

      }
   }

   public void generateReport() {
      double var1 = (double)0.0F;

      for(Sale var4 : this.sales) {
         var1 += var4.getTotalAmount();
      }

      System.out.println("===============================");
      System.out.println("  Sales Report ");
      System.out.println("===============================");
      System.out.println("Total Sales: " + this.sales.size());
      System.out.println("Total Revenue: P" + var1);
=======
public class Inventory implements Reportable {
   private final List<Product> products = new ArrayList<>();

   public void addProduct(Product product){
      if (product==null){
         System.out.println("cannot add null");
         return;
      }
      products.add(product);
      System.out.println("added successfully");
   }
   public List<Product>getProducts(){
      return products;
   }

   public Product findProductByName(String value){

      for(Product product : products){

         if(product.getName().equalsIgnoreCase(value)||product.getProductID().equalsIgnoreCase(value)){
            return product;
         }
      }
      return null;
   }

   public void searchProduct(String value){
      Product product = findProductByName(value);
      if(product == null){
         System.out.println("Product not fund");
      } else {
         product.display();
      }
   }

   public void viewStock(){
      if (products.isEmpty()){
         System.out.println("No products in Stock");
         return;
      }
      for (Product product : products){
         product.display();
         System.out.println("");
      }
   }

   @Override 
   public void generateReport(){
      System.out.println("Inventory Report");
      for (Product product : products){
         product.display();
      }
      System.out.println("Total Products" + products.size());
>>>>>>> 29313cd (update (Pako and Legae))
   }
}
