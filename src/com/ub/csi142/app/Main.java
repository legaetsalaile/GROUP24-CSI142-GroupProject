package com.ub.csi142.app;

import com.ub.csi142.service.Inventory;
import com.ub.csi142.service.SalesManager;
import com.ub.csi142.util.InputHelper;

public class Main{
    public static void main(String[]args){

        Inventory inventory = new Inventory();
        SalesManager salesManager = new SalesManager();
        InputHelper input = new InputHelper();
        System.out.println("=========================================");
        System.out.println("   Welcome to the 24th Tuckshop System ");
        System.out.println("=========================================");
        
    boolean running = true;
        while(running){
            System.out.println("++-------MAIN MENU-------++");
            System.out.println(" 1. Add Product to Invertory ");
            System.out.println(" 2. RECORD A SALE"); 
            System.out.println(" 3. VIEW ALL STOCK ");
            System.out.println(" 4. PRODUCT SEARCH");
            System.out.println(" 5. VIEW SALES REPORT ");
            System.out.println(" 6. EXIT ");
            System.out.println("++------------------------++");

            int choice = input.getInt("Enter your choice: ");
        switch (choice){
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
                System.out.println("Exiting the system. Thank you and Goodbye!");
                running = false;
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option from 1-6.");
        }
        }
        input.closeScanner();
    }
}
                
