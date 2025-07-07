package com.learn.inventory_manager.repository;

import com.learn.inventory_manager.model.Product;

import java.util.List;

public interface InventoryRepository {
    List<Product> loadInventory();
}
