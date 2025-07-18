package com.learn.inventory_manager.data;

import com.learn.inventory_manager.models.Product;

import java.util.List;

public interface InventoryRepository {
    List<Product> getAll();

    Product findById(String productId);

    Product add(Product product);

    boolean update(Product product);

    boolean deleteById(String productId);
}