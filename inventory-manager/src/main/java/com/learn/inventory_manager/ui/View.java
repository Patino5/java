package com.learn.inventory_manager.ui;

import com.learn.inventory_manager.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Component
public class View {
    private final TextIO io;

    public View(TextIO io) {
        this.io = io;
    }

    public int chooseMenuOption() {
        displayHeader("Inventory Manager Menu");
        io.println("1. Add Product");
        io.println("2. View Products");
        io.println("3. Search Product");
        io.println("4. Update Product");
        io.println("5. Delete Product");
        io.println("6. Exit");
        io.println("");
        return io.readInt("Enter your choice: ", 1, 6);
    }

    public void displayHeader(String message) {
        io.println("");
        io.println("═".repeat(message.length() + 12));
        io.println("===== " + message.toUpperCase() + " =====");
        io.println("═".repeat(message.length() + 12));

    }

    public void displayProducts(List<Product> products) {
        displayHeader("Inventory List");
        String tableHeader = String.format(" %-3s  %-15s  %3s  %9s", "ID", "NAME", "QTY", "PRICE");

        if (products.isEmpty()) {
            io.println("No Products Available");
        } else {
            io.println("─".repeat(tableHeader.length()));
            io.println(tableHeader);
            io.println("─".repeat(tableHeader.length()));
            for (Product product : products) {
                io.printf("%-4s  %-15s  %-3d  $%8.2f%n",
                        product.getProductID(),
                        product.getProductName(),
                        product.getQuantity(),
                        product.getPrice());
            }
        }
        io.println("═".repeat(tableHeader.length()));
        io.println("");
    }

    public Product createProduct() {
        displayHeader("Add Product");
        Product result = new Product();
        String productId = io.readString("Enter Product ID: ");
        String productName = io.readString("Enter Product Name: ");
        int quantity = io.readInt("Enter Quantity: ");
        BigDecimal price = io.getBigDecimal("Enter Price: ");


        return result;
    }

    public Product updateProduct(Product p) {
        displayHeader("Update Product");

        io.println(p.toString());

        Integer qty = io.readInt("Enter New Quantity (or press Enter to skip): ");
        if (qty != null) {
            p.setQuantity(qty);
        }

        BigDecimal price = io.getBigDecimal("Enter New Price (or press Enter to skip): ");
        if (price != null) {
            p.setPrice(price);
        }

        return p;
    }

    public Product chooseProduct(List<Product> products) {
        displayProducts(products);
        Product result = null;
        if (!products.isEmpty()) {
            String productId = io.readString("Choose a Product ID:");
            for (Product p : products) {
                if (Objects.equals(p.getProductID(), productId)) {
                    result = p;
                    return result;
                }
            }
        }
        return result;
    }

    private void pressEnterToContinue() {
        io.readString("Press Enter to return to the main menu...");
    }

    public void displayErrors(List<String> errors) {
        io.println("Errors:");
        for (String error : errors) {
            io.println(error);
        }

    }

    public void displayMessage(String message) {
        io.println("");
        io.println(message);
    }
}
