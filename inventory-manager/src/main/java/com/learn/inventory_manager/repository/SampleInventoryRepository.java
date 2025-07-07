package com.learn.inventory_manager.repository;

import com.learn.inventory_manager.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class SampleInventoryRepository implements InventoryRepository {

    @Override
    public List<Product> loadInventory() {
        return List.of(
                new Product("101", "Laptop", 10, new BigDecimal("999.99")),
                new Product("102", "Mouse", 50, new BigDecimal("25.00")),
                new Product("103", "Keyboard", 30, new BigDecimal("49.99"))
        );
    }
}
