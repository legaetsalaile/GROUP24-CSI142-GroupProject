package com.ub.csi142.contracts;

public class Reportable{import java.util.ArrayList;


interface Reportable {
    void generateReport();
}

// Base Product class
class Product implements Reportable {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void generateReport() {
        System.out.println("Product Report");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}


class PerishableProduct extends Product {
    private String expiryDate;

    public PerishableProduct(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void generateReport() {
        System.out.println("Perishable Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Expiry Date: " + expiryDate);
    }
}


class NonPerishableProduct extends Product {

    public NonPerishableProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public void generateReport() {
        System.out.println("Non-Perishable Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

// Sale Item
class SaleItem implements Reportable {
    private Product product;
    private int quantity;

    public SaleItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.price * quantity;
    }

    @Override
    public void generateReport() {
        System.out.println("Sale Item");
        System.out.println("Product: " + product.name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + getTotal());
    }
}

// Sale class
class Sale implements Reportable {
    private ArrayList<SaleItem> items = new ArrayList<>();

    public void addItem(SaleItem item) {
        items.add(item);
    }

    @Override
    public void generateReport() {
        System.out.println("\n=== Sale Report ===");
        double total = 0;

        for (SaleItem item : items) {
            item.generateReport();
            total += item.getTotal();
            System.out.println("------------------");
        }

        System.out.println("Total Sale Amount: " + total);
    }
}

// Inventory class
class Inventory implements Reportable {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    @Override
    public void generateReport() {
        System.out.println("=== Inventory Report ===");

        for (Product p : products) {
            p.generateReport();
            System.out.println("-----------------");
        }
    }
}

// Sales Manager
class SalesManager implements Reportable {
    private String name;

    public SalesManager(String name) {
        this.name = name;
    }

    @Override
    public void generateReport() {
        System.out.println("\nSales Manager");
        System.out.println("Name: " + name);
    }
}

// Input Helper (simple version)
class InputHelper {

    public static Product sampleProduct() {
        return new Product("Sample Product", 10.0);
    }

    public static int sampleQuantity() {
        return 2;
    }
}

// MAIN CLASS (must match filename)
public class Reportable {

    public static void main(String[] args) {

        // Inventory
        Inventory inventory = new Inventory();
        inventory.addProduct(new PerishableProduct("Milk", 15.0, "2026-05-10"));
        inventory.addProduct(new NonPerishableProduct("Rice", 40.0));

        // Sale
        Sale sale = new Sale();
        sale.addItem(new SaleItem(new PerishableProduct("Eggs", 12.0, "2026-06-01"), 2));
        sale.addItem(new SaleItem(new NonPerishableProduct("Soap", 8.0), 3));

        // Manager
        SalesManager manager = new SalesManager("Sharon");

        // Reports
        inventory.generateReport();
        sale.generateReport();
        manager.generateReport();
    }
}
    
}