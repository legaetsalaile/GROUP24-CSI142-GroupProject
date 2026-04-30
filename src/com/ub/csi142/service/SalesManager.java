package com.ub.csi142.service;

import java.util.ArrayList;
import java.util.List;
import com.ub.csi142.contracts.Reportable;
import com.ub.csi142.model.Product;
import com.ub.csi142.model.Sale;
import com.ub.csi142.model.SaleItem;
import com.ub.csi142.util.InputHelper;

public class SalesManager implements Reportable {
    private final List<Sale> sales;

    public SalesManager() {
        this.sales = new ArrayList<>();
    }

    public void recordSale(Inventory inventory, InputHelper input) {
        if (inventory == null || input == null) {
            System.out.println("Sales cannot be recorded because inventory or input helper is missing.");
            return;
        }
        if (inventory.getProducts().isEmpty()) {
            System.out.println("No products available to sell.");
            return;
        }

        String search = input.getString("Enter product name or ID: ");
        Product product = inventory.findProductByName(search);
        if (product == null) {
            System.out.println("Product not found: " + search);
            return;
        }

        int quantity = input.getInt("Enter quantity to sell: ");
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }
        if (quantity > product.getQuantity()) {
            System.out.println("Not enough stock. Available: " + product.getQuantity());
            return;
        }

        product.reduceStock(quantity);
        Sale sale = new Sale();
        sale.addSaleItem(new SaleItem(product, quantity));
        sales.add(sale);
        sale.printReceipt();
    }

    public void viewSalesReport() {
        if (sales.isEmpty()) {
            System.out.println("No sales recorded.");
            return;
        }
        System.out.println("View Sales Report");
        for (Sale sale : sales) {
            System.out.println(sale);
            System.out.println("------------------------------");
        }
    }

    @Override
    public void generateReport() {
        double totalRevenue = 0;
        for (Sale sale : sales) {
            totalRevenue += sale.getTotalAmount();
        }
        System.out.println("===============================");
        System.out.println("  Sales Report ");
        System.out.println("===============================");
        System.out.println("Total Sales: " + sales.size());
        System.out.println("Total Revenue: P" + totalRevenue);
    }
}
