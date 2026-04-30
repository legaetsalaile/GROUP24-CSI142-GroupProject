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

   public static void main(String[] var0) {
      Inventory var1 = new Inventory();
      SalesManager var2 = new SalesManager();
      InputHelper var3 = new InputHelper();
      var1.addProduct(new PerishableProduct("Milk", "P001", 10, (double)5.0F, LocalDate.now().plusDays(7L)));
      var1.addProduct(new NonperishableProduct("Rice", "NP001", 20, (double)10.0F, 12));
      System.out.println("=========================================");
      System.out.println("   Welcome to the 24th Tuckshop System ");
      System.out.println("=========================================");
      boolean var4 = true;

      while(var4) {
         System.out.println("++-------MAIN MENU-------++");
         System.out.println(" 1. Add Product to Inventory ");
         System.out.println(" 2. Record a Sale");
         System.out.println(" 3. View All Stock ");
         System.out.println(" 4. Product Search");
         System.out.println(" 5. View Sales Report ");
         System.out.println(" 6. Generate Inventory Report ");
         System.out.println(" 7. Exit ");
         System.out.println("++------------------------++");
         int var5 = var3.getInt("Enter your choice: ");
         switch (var5) {
            case 1:
               String var6 = var3.getString("Enter product type (perishable/non-perishable): ");
               String var7 = var3.getString("Name: ");
               String var8 = var3.getString("ID: ");
               int var9 = var3.getInt("Quantity: ");
               double var10 = var3.getDouble("Price: ");
               if (var6.equalsIgnoreCase("perishable")) {
                  int var13 = var3.getInt("Days until expiry: ");
                  var1.addProduct(new PerishableProduct(var7, var8, var9, var10, LocalDate.now().plusDays((long)var13)));
               } else {
                  int var14 = var3.getInt("Shelf life (months): ");
                  var1.addProduct(new NonperishableProduct(var7, var8, var9, var10, var14));
               }
               break;
            case 2:
               var2.recordSale(var1, var3);
               break;
            case 3:
               var1.viewStock();
               break;
            case 4:
               String var12 = var3.getString("Enter product name or ID: ");
               var1.searchProduct(var12);
               break;
            case 5:
               var2.viewSalesReport();
               break;
            case 6:
               var1.generateReport();
               break;
            case 7:
               System.out.println("Exiting the system. Thank you and Goodbye!");
               var4 = false;
               break;
            default:
               System.out.println("Invalid choice. Please enter a valid option from 1-7.");
         }
      }

      var3.closeScanner();
   }
}