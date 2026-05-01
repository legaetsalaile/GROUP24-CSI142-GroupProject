package com.ub.csi142.app;

import com.ub.csi142.model.NonperishableProduct;
import com.ub.csi142.model.PerishableProduct;
import com.ub.csi142.service.Inventory;
import com.ub.csi142.service.SalesManager;
import com.ub.csi142.util.InputHelper;
import java.time.LocalDate;

public class Main {
   public Main() {
   }

   public static void main(String[] args) {

      Inventory inventory = new Inventory();
      SalesManager salesManager = new SalesManager();
      InputHelper input = new InputHelper();


      
      System.out.println("=========================================");
      System.out.println("   Welcome to the 24th Tuckshop System ");
      System.out.println("=========================================");
      boolean running = true;

      while(running) {
         System.out.println("++-------MAIN MENU-------++");
         System.out.println(" 1. Add Product to Inventory ");
         System.out.println(" 2. Record a Sale");
         System.out.println(" 3. View All Stock ");
         System.out.println(" 4. Product Search");
         System.out.println(" 5. View Sales Report ");
         System.out.println(" 6. Generate Inventory Report ");
         System.out.println(" 7. Exit ");
         System.out.println("++------------------------++");


         int choice = input.getInt("Enter your choice: ");
         switch (choice) {
            case 1:
               String type = input.getString("Enter product type (perishable/non-perishable): ");
               String name = input.getString("Name: ");
               String id = input.getString("ID: ");
               int qty = input.getInt("Quantity: ");
               double price = input.getDouble("Price: ");


               if (type.equalsIgnoreCase("perishable")) {
                  int days = input.getInt("Days until expiry: ");
                  inventory.addProduct (new PerishableProduct(name, id, qty, price, LocalDate.now().plusDays(days)));

               } else {
                  int shelf = input.getInt("Shelf life (months): ");
                  inventory.addProduct(new NonperishableProduct(name, id, qty, price, shelf));
               }
               break;
            case 2:
               salesManager.recordSale(inventory, input);
               break;
            case 3:
               inventory.viewStock();
               break;
            case 4:
               
               inventory.searchProduct(input.getString("enter name or id"));
               break;
            case 5:
               salesManager.viewSalesReport();
               break;
            case 6:
               inventory.generateReport();
               break;
            case 7:
               System.out.println("Exiting the system. Thank you and Goodbye!");
               running = false;
               break;
            default:
               System.out.println("Invalid choice. Please enter a valid option from 1-7.");
         }
      }

      input.closeScanner();
   }
}
