package com.ub.csi142.service;

import java.util.ArrayList;
import java.util.List;
import com.ub.csi142.contracts.Reportable;
import com.ub.csi142.model.Product;

public class Inventory implements Reportable {
    private final List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        this.products.add(product);
        System.out.println("Successfully added: " + product.getName());
    }

    public void searchProduct(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Please provide a valid product name.");
            return;
        }
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name) || product.getProductID().equalsIgnoreCase(name)) {
                System.out.println("Product found:");
                product.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found: " + name);
        }
    }

    public Product findProductByName(String name) {
        if (name == null) {
            return null;
        }
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name) || product.getProductID().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void updateProduct(String productID, double newPrice) {
        Product product = findProductByName(productID);
        if (product == null) {
            System.out.println("Product not found: " + productID);
            return;
        }
        product.setPrice(newPrice);
        System.out.println("Product updated: " + product.getName() + " - P" + product.getPrice());
    }

    public void viewStock() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Current Stock:");
        for (Product product : products) {
            product.display();
            System.out.println("---");
        }
    }

    @Override
    public void generateReport() {
        System.out.println("===============================");
        System.out.println("  Inventory Stock Report ");
        System.out.println("===============================");
        if (products.isEmpty()) {
            System.out.println("No products in the inventory.");
        } else {
            for (Product product : products) {
                System.out.println("Product: " + product.getName() + " - Price: P" + product.getPrice() + " - Quantity: " + product.getQuantity());
            }
        }
        System.out.println("===============================");
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
