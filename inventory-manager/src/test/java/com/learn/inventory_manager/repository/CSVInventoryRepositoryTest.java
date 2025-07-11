package com.learn.inventory_manager.repository;

import com.learn.inventory_manager.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.TestPropertySource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@SpringBootTest(classes = CSVInventoryRepositoryTest.TestConfig.class)
@TestPropertySource(properties = {
        "products.csv.filepath=data/test/products-test.csv",
        "products.csv.seedpath=data/test/products-test-seed.csv"
})
class CSVInventoryRepositoryTest {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Value("${products.csv.seedpath}")
    private String seedPath;

    @Value("${products.csv.filepath}")
    private String testPath;

    @BeforeEach
    void setUp() throws IOException {
        // Copy seed file to target location
        Path seedFile = Paths.get(seedPath);
        Path targetFile = Paths.get(testPath);

        Files.copy(seedFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void canLoadData() {
        List<Product> items = inventoryRepository.getAll();
        assertEquals(3, items.size());
        assertEquals("keyboard", items.getFirst().getProductName());
    }


    @Configuration
    static class TestConfig {
        @Bean
        public InventoryRepository inventoryRepository() {
            return new CSVInventoryRepository();
        }
    }
}
