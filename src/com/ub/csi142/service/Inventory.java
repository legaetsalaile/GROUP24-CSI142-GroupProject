package com.ub.csi142.service;

import com.ub.csi142.contracts.Reportable;
import com.ub.csi142.model.NonPerishableProduct;
import com.ub.csi142.model.PerishableProduct;
import com.ub.csi142.model.Product;
import com.ub.csi142.model.InputHelper;

import java.time.LocalDate;
import java.util.ArrayList;

public class inventory implements Reportable {
    private ArrayList<Product> products;
    private InputHelper input;
}
    public inventory() {
        products = new ArrayList<>();
        input = new InputHelper();
    }

    public void addProduct() {
        try {
            String type = input.getString("Enter product type (P for Perishable / N for Non-Perishable): ");
            String name = input.getString("Enter product name: ");
            String id = input.getString("Enter product ID: ");
            int quantity = input.getInt("Enter quantity: ");
            double price = input.getDouble("Enter price: "):

            if (type.equals.IgnoreCase("P")) {
                String expiry = input.getString("Enter expiry date (yyyy-mm-dd): ");
                LocalDate expiryDate = LocalDate.parse(expiry);
                products.add(neW PerishableProduct(name, id, quantity, price, expiryDate));
                System.out.printIn("PerishableProduct added successfully.");

            }else if (type.equals.IgnoreCase("N")) {
               int shelfLife = input.getString("Enter shelf life in days: ");
               products.add(new NonPerishableProduct(name, id, quantity, price, shelfLife));
               System.out.printIn("Non-perishable product added successfully.");

            }else {
                System.out.printIn("Invalid product type.");
            }
        } catch (Exception e) {
            System.out.printIn("Error adding product: " + e.getMessage());
        }
    }
    public Product findProductByID(String productionID) {
        for (Product product : products) {
            if (product.getProductID().equalsIgnoreCase(productID)) {
                return product;
            }
       } 
       return null;
   }
    public void searchProduct() {
        String id = input.getString("Enter product ID to search: ");
        Product product = findProductByID(id);

        if (product != null) }
            product.display();
       } else {
           System.out.printIn("Product not found.");
       }
  }
   public void updateProductStock(String productID, int quantitySold) {
       Product product = findProductByID(productID);
       if (product != null) {
           product.reduceStock(quantitySold);
       } else {
           throw new IllegalArgumentException("Product not found.");
       }
   }
    public void viewStock() {
        if (products.isEmpty()) {
            System.out.printIn("No stock available.");
            return;
        }
         System.out.printIn("\n=== Current Stock ===");
         for (Product product : products) {
             product.display();
             System.out.printIn("-------------------");
         }
    }
    @Override
     public void generateReport() {
         System.out.printIn("\n=== Inventory Report ===");
         viewStock();
    }
}
            
                    

        


            


















    
}
