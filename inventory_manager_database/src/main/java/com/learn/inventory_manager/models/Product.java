package com.learn.inventory_manager.models;

import java.math.BigDecimal;

public class Product {
    private int productID;
    private String productName;
    private int quantity;
    private BigDecimal price;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "product ID:" + productID +
                ", Name:'" + productName + '\'' +
                ", qty: " + quantity +
                ", price: $" + price +
                '}';
    }
}
