package com.learn.inventory_manager.repository;

import com.learn.inventory_manager.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class CSVInventoryRepository implements InventoryRepository {
    private final List<Product> products = new ArrayList<>();
    @Value("${products.csv.filepath:data/products.csv}")
    private String filePath;
    private static final String CSV_HEADER = "ProductId,ProductName,Quantity,Price";

    @PostConstruct
    public void init() {
        loadFile();
    }

    @Override
    public List<Product> getAll() {
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
        products.add(product);
        writeToFile(products);
        return product;
    }

    @Override
    public boolean update(Product product) throws DataAccessException {
        for (int i = 0; i < products.size(); i++) {
            if (Objects.equals(products.get(i).getProductID(), product.getProductID())) {
                products.set(i, product);
                writeToFile(products);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(String productId) throws DataAccessException {
        for (Product product : products) {
            if (product.getProductID().equalsIgnoreCase(productId)) {
                products.remove(product);
                writeToFile(products);
                return true;
            }
        }
        return false;
    }

    private void loadFile() {
        File csvFile = new File(filePath);

        if(!csvFile.exists()) {
            return;
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
                                Integer.parseInt(parts[2].trim()),
                                new BigDecimal(parts[3].trim())
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
    }


    private void writeToFile(List<Product> products) throws DataAccessException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(CSV_HEADER);
            for (Product product : products) {
                writer.println(productToLine(product));
            }

        } catch (IOException e) {
            throw new DataAccessException("Could not write to file path: " + filePath);
        }
    }

    private String productToLine(Product product) {
        return String.format("%s,%s,%d,%s",
                product.getProductID(),
                product.getProductName(),
                product.getQuantity(),
                product.getPrice());
    }
}
