package com.ub.csi142.model;

public class Sale{ 
    private String productName;
    private int quantity;
    private double price;

    
    public Sales(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public double calculateTotalSales() {
        return quantity * price;
    }


    public void displaySales() {
        System.out.println("Product: " + productName);
        System.out.println("Quantity : " + quantity);
        System.out.println("Price t: " + price);
        System.out.println("Total Sales: " + calculateTotalSales());
    }


    public static void main(String[] args) {
        Sales sale1 = new Sales("Iphone", 5, 7500.00);
        sale1.displaySales();
    }
}
    
