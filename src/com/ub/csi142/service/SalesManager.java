package com.ub.csi142.service;
import com.ub.csi142.contracts.Reportable;
import java.util.ArrayList;

public class SalesManager implements Reportable{
    private ArrayList<SaleItem> saleItems;

    public SalesManager(){
        this.saleItems = new ArrayList<>();
    }
    //record sale method will take inventory as parameter to check if the product is available and then record the sale
    public void recordSale(Inventory inventory){
       saleItems.add(sale);
       System.out.println("Record sale");
    }

    public void viewSalesReport(){
        if (sales.isEmpty()){
            System.out.println("No sales recorded.");
            return;
        }
        System.out.println("View sales Report");
        for(Sale sale : sales){
            System.out.println(sale);
            System.out.println("------------------------------");
        }
        @Override
        public void generateReport() {
            double totalRevenue = 0;
            for(Sale sale : sales){
                totalRevenue += sale.getTotalAmount();
            }
            System.out.println("===============================");
            System.out.println("  Sales Report ");
            System.out.println("===============================");
            System.out.println("Total Sales: " + sales.size());
            System.out.println("Total Revenue: P" + totalRevenue);
        }

    }
}