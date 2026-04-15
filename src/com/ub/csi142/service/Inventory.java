package com.ub.csi142.service;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements Reportable{
    private List<Product>product;
    public Inventory(){
        this.product = new ArrayList<>();
         
    }
    public void addProduct(Product product){
        this.product.add(product);
        System.out.println("Successfully added: " + product.getName());
    }
    public void searchProduct(String productID){//or ke String name
        System.out.println("Search for a product by name:");
        String searchName = System.console().readLine();
        boolean found = false;
        for(Product product : product){
            if(product.getName().equalsIgnoreCase(productID)){// is it productID or product name?
                System.out.println("Product found: " + product.getName() + " -P" + product.getPrice());
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Product not found: " + productID);
        }
        public void updateProduct(String productID, double newPrice){
            for(Product product : product){
                if(product.getName().equalsIgnoreCase(productID)){
                    product.setPrice(newPrice);
                    System.out.println("Product updated: " + product.getName() + " -P" + product.getPrice());
                    return;
                }else{
                    System.out.println("Error!! Product" + product.getName() + " not found" );
                }
            }
        }
        @Override
        public void generateReport() {
            System.out.println("===============================");
            System.out.println("  Inventory Stock Report ");
            System.out.println("===============================");
            if(product.isEmpty()){
                System.out.println("No products in the inventory.");
            } else {
                for(Product product : product){
                    System.out.println("Product: " + product.getName() + " - Price: P" + product.getPrice() + " - Quantity: " + product.getQuantity() ););
                }
            }
            System.out.println("===============================");
        }
        public List<Product> getProducts(){
            return product;
        }
    }
}