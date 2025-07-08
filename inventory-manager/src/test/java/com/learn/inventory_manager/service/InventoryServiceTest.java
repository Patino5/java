package com.learn.inventory_manager.service;

import com.learn.inventory_manager.model.Product;
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
    void shouldNotAddNullProduct() {
        Product product = new Product();

        InventoryResult result = service.add(product);

        assertFalse(result.isSuccess());
        assertEquals(4, result.getErrorMessages().size()); // no name, no id, no price, no qty
        assertTrue(result.getErrorMessages().getFirst().contains("`ID`"));
        assertTrue(result.getErrorMessages().getLast().contains("`quantity`"));
    }

    @Test
    void shouldAdd() {
        Product product = new Product("299", "Headphones", 30, new BigDecimal("249.99"));

        InventoryResult result = service.add(product);

        assertTrue(result.isSuccess());
    }
}