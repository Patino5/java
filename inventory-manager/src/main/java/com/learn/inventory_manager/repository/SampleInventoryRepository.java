package com.learn.inventory_manager.repository;

import com.learn.inventory_manager.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SampleInventoryRepository implements InventoryRepository {
    private ArrayList<Product> products = new ArrayList<>();

    public SampleInventoryRepository() {
        products.add(new Product("101", "Laptop", 10, new BigDecimal("999.99")));
        products.add(new Product("102", "Mouse", 50, new BigDecimal("25.00")));
        products.add(new Product("103", "Keyboard", 30, new BigDecimal("49.99")));
    }

    @Override
    public List<Product> loadInventory() {
        return new ArrayList<>(products);
    }

    @Override
    public Product findById(String productId) {
        for (Product product : products) {
            if (product.getProductID().equalsIgnoreCase(productId)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findByName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product add(Product product) throws DataAccessException {
        return product;
    }

    @Override
    public boolean update(Product product) {
        return findById(product.getProductID()) != null;
    }

    @Override
    public boolean deleteById(String productId) throws DataAccessException {
        for (Product product : products) {
            if (product.getProductID().equalsIgnoreCase(productId)) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }
}
