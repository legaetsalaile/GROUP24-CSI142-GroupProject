package com.ub.csi142.service;

import com.ub.csi142.contracts.Reportable;
import com.ub.csi142.model.Product;
import com.ub.csi142.model.Sale;
import com.ub.csi142.model.SaleItem;
import com.ub.csi142.util.InputHelper;
import java.util.ArrayList;
import java.util.List;

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

   }
}
