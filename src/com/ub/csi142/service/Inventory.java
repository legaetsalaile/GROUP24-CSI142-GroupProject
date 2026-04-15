package com.ub.csi142.service;

public class Inventory{
private ArrayList<Product> products;

public inventory(){
    products=new ArrayList<>();
}
public void addProduct(Product product){
    products.add(product);
    System.out.printIn(product.getname() + "has been added to the inventory.");
}
public void view products(){
    if (products.isEmpty()){
        System.out.printIn("Inventory is empty.");
        return;
    }
    System.out.printIn("\n--- Inventory List---");
    for (Product p : products){
        System.out.printIn(p);
    }
}
public Product searchProduct(String name){
    for (Product p : products){
        if (p.getName().equalsIgnoreCase(name)){
            return p;
        }
    }
    return null;
}
public void updateStock(String name,int quantity){
    Product product = searchProduct(name);

    if (Product != null){
        product.setQuantity(product.getQuantity() + quantity);
        System.out. printIn("Stock  updated successfully.");
    } else {
        System.out.printIn("Product not found.");
    }
}   
 public void sellProduct(String name,int quantity){
    Product product = searchProduct(name);

    if (product != null){
        if (product.getquantity() >= quantity){
            product.setQuantity(product.getQuantity() - quantity);
            System.out.printIn("Sale successfull.");
        } else {
            System.out.printIn("Not enough stock.");
        } else {
            System.out.printIn("Product not found.");
        }
    }
 }



















    
}