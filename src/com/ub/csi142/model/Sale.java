package com.ub.csi142.model;

import java.util.ArrayList;
import com.ub.csi142.service.SalesManager;

public class Sale{
    private ArrayList<SaleItem> items;
    public Sale(){
        saleitems = new ArrayList<>();
    }
    public void addSaleItem(SaleItem saleitem){
        saleitems.add(saleitem);
    }
    public double calculateTotal(){
        double total = 0.0;
        for (SaleItem item : saleitems){
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }
    public void printReceipt(){
        System.out.println("\n--- Receipt ---");
        for (SaleItem item : saleitems){
            System.out.println(item.getProduct().getName() + " x" + item.getQuantity() + " - P" + (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("Total: P" + calculateTotal());
    }
    
}