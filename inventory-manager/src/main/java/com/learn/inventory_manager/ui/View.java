package com.learn.inventory_manager.ui;

import com.learn.inventory_manager.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

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
        String tableHeader = String.format(" %-3s  %-15s  %3s  %9s", "ID", "NAME", "QTY", "PRICE");
        int itemsTotal = 0;
        BigDecimal itemsProfit = new BigDecimal("0");

        io.println("═".repeat(tableHeader.length()));
        io.println("=".repeat(tableHeader.length() / 4 + 1) +
                " INVENTORY  LIST " +
                "=".repeat(tableHeader.length() / 4 + 1));
        io.println("═".repeat(tableHeader.length()));

        if (products.isEmpty()) {
            io.println("No Products Available");
        } else {
            io.println(tableHeader);
            io.println("─".repeat(tableHeader.length()));
            for (Product product : products) {
                String id = product.getProductID();
                String name = product.getProductName();
                int qty = product.getQuantity();
                BigDecimal price = product.getPrice();

                if (name.length() > 15) {
                    name = name.substring(0, 12) + "...";
                }

                io.printf("%-4s  %-15s  %-3d  $%8.2f%n",
                        id,
                        name,
                        qty,
                        price);

                itemsTotal += qty;
                BigDecimal subtotal = price.multiply(BigDecimal.valueOf(qty));
                itemsProfit = itemsProfit.add(subtotal);
            }
        }
        io.println("═".repeat(tableHeader.length()));
        io.println("Total Products: " + products.size() +
                "\nTotal Items: " + itemsTotal +
                "\nGross Profit: $" + itemsProfit);
    }

    public Product createProduct() {
        displayHeader("Add Product");

        String productId = io.readString("Enter Product ID or Leave Blank to cancel: ");
        if (productId.isEmpty()) {
            io.println("Add Product operation cancelled, ID cannot be blank.");
            return null;
        }
        String productName = io.readString("Enter Product Name: ");
        int quantity = io.readInt("Enter Quantity: ");
        BigDecimal price = io.getBigDecimal("Enter Price: ");

        return new Product(productId, productName, quantity, price);
    }

    public Product updateProduct(Product p) {
        displayMessage("Current Details:");

        io.println(p.toString());
        io.println("");

        Integer qty = io.readInt("Enter New Quantity (or press Enter to skip): ", true);
        if (qty != null) {
            p.setQuantity(qty);
        }

        BigDecimal price = io.getBigDecimal("Enter New Price (or press Enter to skip): ", true);
        if (price != null) {
            p.setPrice(price);
        }

        return p;
    }

    public Product deleteProduct(Product p) {

        if (io.getConfirmation("Are you sure you want to delete this product? (y/n): ")) {
            return p;
        }
        return null;
    }

    public Product chooseProduct(List<Product> products) {
        Product result = null;
        if (!products.isEmpty()) {
            String productNameOrId = io.readString("Enter Product ID or Name: ");
            for (Product p : products) {
                if (p.getProductID().equalsIgnoreCase(productNameOrId) || p.getProductName().equalsIgnoreCase(productNameOrId)) { // contains method for partial search
                    result = p;
                    return result;
                }
            }
        }
        return result;
    }

    public void pressEnterToContinue() {
        io.readString("\nPress Enter to return to the main menu...");
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
