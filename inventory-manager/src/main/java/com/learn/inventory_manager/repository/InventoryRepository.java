package com.learn.inventory_manager.repository;

import com.learn.inventory_manager.model.Product;

import java.util.List;

public interface InventoryRepository {

    List<Product> getAll();

    Product findById(String productId);

    Product findByName(String productName);

    Product add(Product product) throws DataAccessException;

    boolean update(Product product) throws DataAccessException;

    boolean deleteById(String productId) throws DataAccessException;
}
