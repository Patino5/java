package com.learn.inventory_manager.service;

import com.learn.inventory_manager.model.Product;
import com.learn.inventory_manager.repository.DataAccessException;
import com.learn.inventory_manager.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository repository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.repository = inventoryRepository;
    }

    public List<Product> getAvailableInventory() {
        return repository.loadInventory();
    }

    public Product getProductById(String productId) {
        return repository.findById(productId);
    }

    public Product getProductByName(String productName) {
        return repository.findByName(productName);
    }

    public InventoryResult add(Product product) throws DataAccessException {
        InventoryResult result = validate(product);

        if (!result.isSuccess()) {
            return result;
        }

        if (product.getProductID() != null) {
            Product existingProduct = getProductById(product.getProductID());
            if (existingProduct != null) {
                result.addErrorMessages("Product `ID` must be unique.");
            }
        }

        if (result.isSuccess()) {
            product = repository.add(product);
            result.setProduct(product);
        }

        return result;
    }

    public InventoryResult update(Product product) throws DataAccessException {
        InventoryResult result = validate(product);

        if (result.isSuccess()) {
            if (repository.update(product)) {
                result.setProduct(product);
            } else {
                String message = String.format("Product id %s was not found.", product.getProductID());
                result.addErrorMessages(message);
            }
        }
        return result;
    }

    public InventoryResult deleteById(String productId) throws DataAccessException {
        InventoryResult result = new InventoryResult();
        if (!repository.deleteById(productId)) {
            String message = String.format("Product id %s was not found", productId);
            result.addErrorMessages(message);
        }
        return result;
    }

    private InventoryResult validate(Product product) {
        InventoryResult result = new InventoryResult();

        if (product == null) {
            result.addErrorMessages("Product cannot be null");
            return result;
        }

        if (product.getProductID() == null || product.getProductID().isBlank()) {
            result.addErrorMessages("Product `ID` is required." );
        }

        if (product.getProductName() == null || product.getProductName().isBlank()) {
            result.addErrorMessages("Product `Name` is required." );
        }

        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            result.addErrorMessages("Product `Price` must be greater than 0.");
        }

        if (product.getQuantity() < 0) {
            result.addErrorMessages("Product `Quantity` must not be negative");
        }

        return result;
    }
}
