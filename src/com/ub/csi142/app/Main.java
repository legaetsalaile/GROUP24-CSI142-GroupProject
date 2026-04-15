package com.ub.csi142.app;

import com.ub.csi142.service.Inventory;
import com.ub.csi142.service.SalesManager;
import com.ub.csi142.util.InputHelper;

public class public class Main{
    public static void main(String[] args) {//cant this be done as a single code for submission?.
        Inventory inventory = new Inventory();
        SalesManager salesManager = new SalesManager();
        InputHelper input = new InputHelper();

        System.out.println("================================");
        System.out.println(" Welcome to 24th Tuckshop System ");
        System.out.println("================================");

        boolean running = true;
        while (running) {
            System.out.println("++------MAIN MENU------++");
            System.out.println("1. Add product to inventory");
            System.out.println("2. record a sale");
            System.out.println("3. View All STOCK");
            System.out.println("4. search for a Product");
            System.out.println("5. View Sales Report");
            System.out.println("6. Exit");
            System.out.println("++---------------------++");
            System.out.println("Please select an option from the menu:");
            int choice = input.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    inventory.addProduct();
                    break;
                case 2:
                    salesManager.recordSale(inventory);
                    break;
                case 3:
                    inventory.viewStock();
                    break;
                case 4:
                    inventory.searchProduct();
                    break;
                case 5:
                    salesManager.viewSalesReport();
                    break;
                case 6:
                    System.out.println("Exiting the system.Thank you and Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option from 1 - 6.");
            }

    }
}
    
}public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        SalesManager salesManager = new SalesManager();

        int choice;

        do {
            System.out.println("\n====== PRODUCT & SALES SYSTEM ======");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Make Sale");
            System.out.println("4. View Sales");
            System.out.println("5. View Total Revenue");
            System.out.println("6. Generate Report");
            System.out.println("0. Exit");
            System.out.println("===================================");

            choice = InputHelper.getInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    
                    String name = InputHelper.getString("Enter product name: ");
                    double price = InputHelper.getDouble("Enter product price: ");
                    String type = InputHelper.getString("Enter type (perishable/non-perishable): ");

                    if (type.equalsIgnoreCase("perishable")) {
                        String expiry = InputHelper.getString("Enter expiry date: ");
                        inventory.addProduct(new Perishable(name, price, expiry));
                    } else {
                        int warranty = InputHelper.getInt("Enter warranty months: ");
                        inventory.addProduct(new NonPerishable(name, price, warranty));
                    }

                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    
                    inventory.displayProducts();
                    break;

                case 3:
                
                    String productName = InputHelper.getString("Enter product name: ");
                    int quantity = InputHelper.getInt("Enter quantity: ");

                    Product product = inventory.findProductByName(productName);

                    if (product != null) {
                        SaleItem item = new SaleItem(product, quantity);
                        Sale sale = new Sale();
                        sale.addItem(item);

                        salesManager.addSale(sale);

                        System.out.println("Sale completed successfully!");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 4:
                    
                    salesManager.displayAllSales();
                    break;

                case 5:
                
                    System.out.println("Total Revenue: " +
                            salesManager.calculateTotalRevenue());
                    break;

                case 6:
                    
                    salesManager.generateReport();
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (choice != 0);
    }
}
    
}