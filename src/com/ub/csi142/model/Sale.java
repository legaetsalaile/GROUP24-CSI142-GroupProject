package com.ub.csi142.model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private final List<SaleItem> items;

    public Sale() {
        this.items = new ArrayList<>();
    }

    public void addSaleItem(SaleItem saleItem) {
        if (saleItem == null) {
            throw new IllegalArgumentException("Sale item cannot be null");
        }
        this.items.add(saleItem);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (SaleItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void printReceipt() {
        System.out.println("\n--- Receipt ---");
        for (SaleItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total: P" + calculateTotal());
    }

    public double getTotalAmount() {
        return calculateTotal();
    }

    @Override
    public String toString() {
        return "Sale total: P" + calculateTotal() + " (" + items.size() + " item(s))";
    }
}
