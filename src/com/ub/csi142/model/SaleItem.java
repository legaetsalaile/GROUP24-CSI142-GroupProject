package com.ub.csi142.model;

public class SaleItem{
    private Product product;
    private int quantitySold;
    public SaleItem(Product product, int quantitySold){
        this.product = product;
        this.quantitySold = quantitySold;
    }
    public Product getProduct(){
        return product;
    }
    public int getQuantitySold(){
        return quantitySold;
    }
    public double getSubtotal(){
        return product.getPrice() * quantitySold;
    }
    @Override
    public String toString(){
        return product.getName() + " - Quantity: " + quantitySold + " - Subtotal: P" + getSubtotal();
    }
}