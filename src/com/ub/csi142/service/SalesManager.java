package com.ub.csi142.service;

import com.ub.csi142.contracts.Reportable;
import com.ub.csi142.model.Inventory;
import com.ub.csi142.model.Product;
import com.ub.csi142.model.Sale;
import com.ub.csi142.model.SaleItem;
import com.ub.csi142.util.InputHelper;
import java.util.ArrayList;
import java.util.List;

public class SalesManager implements Reportable {
   private final List<Sale> sales = new ArrayList<Sale>();

   public SalesManager() {
   }

   public void recordSale(Inventory inventory, InputHelper inputHelper) {
      if (inventory == null || inputHelper == null) {

         if (inventory.getProducts().isEmpty()) {
            System.out.println("No products available to sell.");
            return;
         }

         String product Name = inputHelper.getString("Enter product name or ID: ");
            Product product = inventory.findProductByName(productName);

            if (inventory == null) {
               System.out.println("Product not found: " + productName);
               return;
            }

            int quantity = inputHelper.getInt("Enter quantity to sell");

            if (quantity <= 0) {
                 System.out.println("Quantity must be greater than zero.");
                 return;
            }

            if (quantity > product.getQuantity()) {
                  System.out.println("Not enough stock. Available: " + product.getQuantity());
                  return;
            }

            product.reduceStock(quantity);

            Sale sale = new Sale();
            sale.addSaleItem(new SaleItem(product, quantity));
            sales.add(sale);

            sale.printReceipt();

         } else {
             System.out.println("Sales cannot be recorded because inventory or input helper is missing.");
         }
      }

   public void viewSalesReport() {

      if (this.sales.isEmpty()) {
         System.out.println("No sales recorded.");
         return;
      }

      System.out.println("View Sales Report");

         for(Sale sale : sales) {
            System.out.println(sale);
            System.out.println("------------------------------");
         }

      }
   }

   public void generateReport() {
      double totalRevenue = 0.0;

      for(Sale sale : this.sales) {
         totalRevenue += sale.getTotalAmount();
      }

      System.out.println("===============================");
      System.out.println("  Sales Report ");
      System.out.println("===============================");
      System.out.println("Total Sales: " + this.sales.size());
      System.out.println("Total Revenue: P" + totalRevenue);
   }
