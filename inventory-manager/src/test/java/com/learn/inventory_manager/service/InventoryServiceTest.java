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
        assertEquals(3, result.getErrorMessages().size()); // no name, no id, no price, no qty
        assertTrue(result.getErrorMessages().getFirst().contains("`ID`"));
        assertTrue(result.getErrorMessages().getLast().contains("`Price`"));
    }

    @Test
    void shouldNotAddProductWithoutId() throws DataAccessException {
        Product product = new Product("", "itemName", 20, new BigDecimal("23.99"));

        InventoryResult result = service.add(product);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`ID`"));
    }

    @Test
    void shouldNotAddProductWithoutName() throws DataAccessException {
        Product product = new Product("55", "", 20, new BigDecimal("23.99"));

        InventoryResult result = service.add(product);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`Name`"));
    }

    @Test
    void canAddProductWithoutQty() throws DataAccessException {
        Product product = new Product();
        product.setProductName("Item");
        product.setProductID("productID");
        product.setPrice(new BigDecimal("23.44"));

        InventoryResult result = service.add(product);

        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotAddProductWithoutPrice() throws DataAccessException {
        Product product = new Product();
        product.setProductName("Item");
        product.setProductID("productID");
        product.setQuantity(4);

        InventoryResult result = service.add(product);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`Price`"));
    }

    @Test
    void shouldNotAddProductWithDuplicateId() throws DataAccessException {
        // id 101 already exists in sample data
        Product product = new Product("101", "Item", 10, new BigDecimal("15.00"));

        InventoryResult result = service.add(product);

        assertFalse(result.isSuccess());
        assertTrue(result.getErrorMessages().contains("Product `ID` must be unique."));
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Product product = new Product("299", "Headphones", 30, new BigDecimal("249.99"));

        InventoryResult result = service.add(product);

        assertTrue(result.isSuccess());
    }

    @Test
    void shouldAddProductWithZeroQuantity() throws DataAccessException {
        Product product = new Product("200", "Zero Quantity Item", 0, new BigDecimal("15.99"));

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

    @Test
    void shouldNotUpdateEmptyID() throws DataAccessException {
        Product product = service.getAvailableInventory().getFirst();
        product.setProductID("");

        InventoryResult result = service.update(product);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`ID`"));
    }

    @Test
    void shouldNotUpdateEmptyName() throws DataAccessException {
        Product product = service.getAvailableInventory().getFirst();
        product.setProductName("");

        InventoryResult result = service.update(product);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`Name`"));
    }

    @Test
    void shouldNotUpdateNegativePrice() throws DataAccessException {
        Product product = service.getAvailableInventory().getFirst();
        product.setPrice(new BigDecimal("-2.00"));

        InventoryResult result = service.update(product);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`Price`"));
    }


    @Test
    void shouldNotUpdateNegativeQuantity() throws DataAccessException {
        Product product = service.getAvailableInventory().getFirst();
        product.setQuantity(-3);

        InventoryResult result = service.update(product);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`Quantity`"));
    }

    @Test
    void shouldUpdateProductWithZeroQuantity() throws DataAccessException {
        Product product = service.getAvailableInventory().getFirst();
        product.setQuantity(0);

        InventoryResult result = service.update(product);

        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotUpdateNonExistentProduct() throws DataAccessException {
        Product product = new Product("999", "Non-existent", 5, new BigDecimal("10.00"));

        InventoryResult result = service.update(product);

        assertFalse(result.isSuccess());
        assertTrue(result.getErrorMessages().contains("Product id 999 was not found."));
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        Product product = service.getAvailableInventory().getFirst();
        product.setProductName("Pencil");
        product.setProductID("106");
        product.setQuantity(14);
        product.setPrice(new BigDecimal(".89"));

        InventoryResult result = service.update(product);

        assertTrue(result.isSuccess());
        assertEquals(0, result.getErrorMessages().size());
    }
}