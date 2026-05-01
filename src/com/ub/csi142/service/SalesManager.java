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

    private final List<Sale> sales = new ArrayList<>();

<<<<<<< HEAD
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
=======
    public void recordSale(Inventory inventory, InputHelper input) {

        if (inventory == null || input == null) {
            System.out.println("Object missing");
            return;
        }

        if (inventory.getProducts().isEmpty()) {
            System.out.println("No products available");
            return;
        }
>>>>>>> 29313cd (update (Pako and Legae))

        String value = input.getString("Enter product name or ID: ");
        Product product = inventory.findProductByName(value);

<<<<<<< HEAD
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
=======
        if (product == null) {
            System.out.println("Product not found");
            return;
        }

        int qty = input.getInt("Enter quantity: ");

        if (qty <= 0) {
            System.out.println("Invalid qty");
            return;
        }

        if (qty > product.getQuantity()) {
            System.out.println("Insufficient stock");
            return;
        }

        product.reduceStock(qty);

        Sale sale = new Sale();
        sale.addSaleItem(new SaleItem(product, qty));
        sales.add(sale);

        sale.printReceipt();
    }

    public void viewSalesReport() {
        if (sales.isEmpty()) {
            System.out.println("No sales");
            return;
        }

        for (Sale sale : sales) {
            System.out.println(sale);
            System.out.println("----------------");
        }
    }

    @Override
    public void generateReport() {
        double total = 0;

        for (Sale sale : sales) {
            total += sale.getTotalAmount();
        }

        System.out.println("Sales Report");
        System.out.println("Total sales: " + sales.size());
        System.out.println("Revenue: " + total);
    }
}
>>>>>>> 29313cd (update (Pako and Legae))
