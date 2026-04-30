package com.ub.csi142.app;

import com.ub.csi142.model.NonPerishableProduct;
import com.ub.csi142.model.PerishableProduct;
import com.ub.csi142.service.Inventory;
import com.ub.csi142.service.SalesManager;
import com.ub.csi142.util.InputHelper;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        SalesManager salesManager = new SalesManager();
        InputHelper input = new InputHelper();

        inventory.addProduct(new PerishableProduct("Milk", "P001", 10, 5.0, LocalDate.now().plusDays(7)));
        inventory.addProduct(new NonPerishableProduct("Rice", "NP001", 20, 10.0, 12));

        System.out.println("=========================================");
        System.out.println("   Welcome to the 24th Tuckshop System ");
        System.out.println("=========================================");

        boolean running = true;
        while (running) {
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
                    int quantity = input.getInt("Quantity: ");
                    double price = input.getDouble("Price: ");
                    if (type.equalsIgnoreCase("perishable")) {
                        int days = input.getInt("Days until expiry: ");
                        inventory.addProduct(new PerishableProduct(name, id, quantity, price, LocalDate.now().plusDays(days)));
                    } else {
                        int shelfLife = input.getInt("Shelf life (months): ");
                        inventory.addProduct(new NonPerishableProduct(name, id, quantity, price, shelfLife));
                    }
                    break;
                case 2:
                    salesManager.recordSale(inventory, input);
                    break;
                case 3:
                    inventory.viewStock();
                    break;
                case 4:
                    String search = input.getString("Enter product name or ID: ");
                    inventory.searchProduct(search);
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
