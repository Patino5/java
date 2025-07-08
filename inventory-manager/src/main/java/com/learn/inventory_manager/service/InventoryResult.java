package com.learn.inventory_manager.service;

import com.learn.inventory_manager.model.Product;

import java.util.ArrayList;
import java.util.List;

public class InventoryResult {
    private ArrayList<String> messages = new ArrayList<>();
    private Product product;

    public List<String> getErrorMessages() {
        return new ArrayList<>(messages);
    }

    public void addErrorMessages(String message) {
        messages.add(message);
    }

    public boolean isSuccess() {
        return messages.isEmpty();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
