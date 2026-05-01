package com.ub.csi142.service;

import com.ub.csi142.contracts.Reportable;
import com.ub.csi142.service.Inventory;
import com.ub.csi142.model.Product;
import com.ub.csi142.model.Sale;
import com.ub.csi142.model.SaleItem;
import com.ub.csi142.util.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class SalesManager implements Reportable {

    private final List<Sale> sales = new ArrayList<>();


    public void recordSale(Inventory inventory, InputHelper input) {

        if (inventory == null || input == null) {
            System.out.println("Object missing");
            return;
        }

        if (inventory.getProducts().isEmpty()) {
            System.out.println("No products available");
            return;
        }


        String value = input.getString("Enter product name or ID: ");
        Product product = inventory.findProductByName(value);

        if (product == null) {
            System.out.println("Product not found");
            return;
        }

        int qty = input.getInt("Enter quantity: ");

        if (qty <= 0) {
            System.out.println("Invalid qty");
            return;
        }

        if (qty > product.getQuantity()) {
            System.out.println("Insufficient stock");
            return;
        }

        product.reduceStock(qty);

        Sale sale = new Sale();
        sale.addSaleItem(new SaleItem(product, qty));
        sales.add(sale);

        sale.printReceipt();
    }

    public void viewSalesReport() {
        if (sales.isEmpty()) {
            System.out.println("No sales");
            return;
        }

        for (Sale sale : sales) {
            System.out.println(sale);
            System.out.println("----------------");
        }
    }

    @Override
    public void generateReport() {
        double total = 0;

        for (Sale sale : sales) {
            total += sale.getTotalAmount();
        }

        System.out.println("Sales Report");
        System.out.println("Total sales: " + sales.size());
        System.out.println("Revenue: " + total);
    }
}
