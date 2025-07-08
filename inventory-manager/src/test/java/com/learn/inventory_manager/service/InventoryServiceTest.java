package com.learn.inventory_manager.service;

import com.learn.inventory_manager.model.Product;
import com.learn.inventory_manager.repository.DataAccessException;
import com.learn.inventory_manager.repository.SampleInventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {

    InventoryService service;

    @BeforeEach
    void setup() {
        SampleInventoryRepository repository = new SampleInventoryRepository();
        service = new InventoryService(repository);
    }

    @Test
    void shouldGetThreeSampleProducts() {
        List<Product> products = service.getAvailableInventory();
        assertEquals(3, products.size());
    }

    @Test
    void shouldNotAddNullProduct() throws DataAccessException {
        Product product = new Product();

        InventoryResult result = service.add(product);

        assertFalse(result.isSuccess());
        assertEquals(4, result.getErrorMessages().size()); // no name, no id, no price, no qty
        assertTrue(result.getErrorMessages().getFirst().contains("`ID`"));
        assertTrue(result.getErrorMessages().getLast().contains("`quantity`"));
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Product product = new Product("299", "Headphones", 30, new BigDecimal("249.99"));

        InventoryResult result = service.add(product);

        assertTrue(result.isSuccess());
    }

    @Test
    void shouldDeleteExistingProduct() throws DataAccessException {
        String existingProductId = "103";

        InventoryResult result = service.deleteById(existingProductId);

        assertTrue(result.isSuccess());
        assertNull(service.getProductById(existingProductId));
    }

    @Test
    void shouldNotDeleteNonAvailableProduct() throws DataAccessException {
        String notAvailableProductId = "324";

        InventoryResult result = service.deleteById(notAvailableProductId);

        assertFalse(result.isSuccess());
        assertTrue(result.getErrorMessages().contains("Product id 324 was not found"));
    }

    @Test
    void shouldHandleNullProductId() throws DataAccessException {
        InventoryResult result = service.deleteById(null);

        assertFalse(result.isSuccess());
        assertTrue(result.getErrorMessages().contains("Product id null was not found"));
    }

    @Test
    void shouldHandleEmptyProductId() throws DataAccessException {
        InventoryResult result = service.deleteById("");

        assertFalse(result.isSuccess());
        assertTrue(result.getErrorMessages().contains("Product id  was not found"));
    }
}