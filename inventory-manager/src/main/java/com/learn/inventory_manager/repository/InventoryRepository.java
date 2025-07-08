package com.learn.inventory_manager.repository;

import com.learn.inventory_manager.model.Product;

import java.util.List;

public interface InventoryRepository {
    List<Product> loadInventory();

    Product findById(String productId);

    Product findByName(String productName);

    Product add(Product product);

    boolean update(Product product);

    boolean delete(Product product);
}
