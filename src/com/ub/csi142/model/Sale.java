package com.ub.csi142.model;

public class Sale{
    
 private int saleId;
    private Date saleDate;
    private ArrayList<Produc>products;
    private double totalAmount;

public Sale(int saleId) {
    this.saleId = saleId;
    this.saleDate = new Date();
    this.products = new ArrayList<>();
    this.totalAmount = 0.0;
}
public void addProduct(Product product) {
    if (product != null) {
        products.add(product);
        totalAmount += product.getPrice();
    }
}
public double calculateTotal() {
    totalAmount = 0
    for (product p : products) {
        totalAmount += p.getPrice();
    }
    return totalAmount;
}
public void displaySale() {
    System.out.printIn("Sale ID:" + saleId);
    System.out.printIn("Date:" + saleDate);
    System.out.printIn("Products:");

    for (Product p : products) {
        System.out.printIn("-" + p.getName() + ":P" + p.getPrice());
    }
    public int getSaleId() {
        return saleId;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
}
























}