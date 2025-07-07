package com.learn.inventory_manager.repository;

import com.learn.inventory_manager.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CSVInventoryRepository implements InventoryRepository {
    private final String filePath = "data/products.csv";

    @Override
    public List<Product> loadInventory() {
        List<Product> products = new ArrayList<>();
        File csvFile = new File(filePath);

        if(!csvFile.exists()) {
            return products;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        Product product = new Product(
                                parts[0].trim(),
                                parts[1].trim(),
                                Integer.parseInt(parts[2]),
                                new BigDecimal(parts[3])
                        );
                        products.add(product);
                    } catch (Exception e) {
                        System.err.println("Error parsing line: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        return products;
    }
}
