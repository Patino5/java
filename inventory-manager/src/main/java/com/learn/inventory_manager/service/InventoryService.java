package com.learn.inventory_manager.service;

import com.learn.inventory_manager.model.Product;
import com.learn.inventory_manager.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Product> getAvailableInventory() {
        return inventoryRepository.loadInventory();
    }
}
