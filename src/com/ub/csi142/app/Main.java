package com.ub.csi142.app;
public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        SalesManager salesManager = new SalesManager();

        int choice;
        int select;

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
        }
    }
}

            
            