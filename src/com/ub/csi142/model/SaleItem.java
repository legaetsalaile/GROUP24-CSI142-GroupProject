package com.ub.csi142.model;

public class SaleItem {
    private Product product;
    private int quantitySold;

    public SaleItem(Product product, int quantitySold) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantitySold <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this.product = product;
        this.quantitySold = quantitySold;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public double getSubtotal() {
        return product.getPrice() * quantitySold;
    }

    @Override
    public String toString() {
        return product.getName() + " x" + quantitySold + " - P" + getSubtotal();
    }
}
