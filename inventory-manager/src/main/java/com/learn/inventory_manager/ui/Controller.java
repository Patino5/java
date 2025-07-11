package com.learn.inventory_manager.ui;

import com.learn.inventory_manager.model.Product;
import com.learn.inventory_manager.repository.DataAccessException;
import com.learn.inventory_manager.service.InventoryResult;
import com.learn.inventory_manager.service.InventoryService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Component
public class Controller {
    private final View view;
    private final InventoryService service;

    public Controller(View view, InventoryService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        try {
            runApp();
        } catch (DataAccessException e) {
            view.displayErrors(List.of(e.getMessage()));
        }
        view.displayHeader("Goodbye");
    }

    private void runApp() throws DataAccessException {
        int choice;
        while ((choice = view.chooseMenuOption()) != 6) {
            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> searchProducts();
                case 4 -> updateProduct();
                case 5 -> deleteProduct();
            }
        }
    }

    private void viewProducts() {
        List<Product> products = service.getAvailableInventory();
        view.displayProducts(products);
        view.pressEnterToContinue();
    }

    private void addProduct() throws DataAccessException {
        Product p = view.createProduct();
        InventoryResult result = service.add(p);
        if (result.isSuccess()) {
            view.displayMessage("Product " + result.getProduct().getProductName() + " added.");
        } else {
            view.displayErrors(result.getErrorMessages());
        }
        view.pressEnterToContinue();
    }

    private void searchProducts() {
        view.displayHeader("Search Product");
        List<Product> foundProducts = getProductsWithPartialSearch();

        if (foundProducts.isEmpty()) {
            view.displayMessage("No products found matching your search.");
        } else {
            view.displayMessage(foundProducts.size() + ((foundProducts.size() > 1) ? " Products Found:" : " Product Found:"));
            for (Product p : foundProducts) {
                String msg = p.toString();
                view.displayMessage(msg);
            }
        }
        view.pressEnterToContinue();
    }

    private void updateProduct() throws DataAccessException {
        view.displayHeader("Update Product");
        Product p = getSingleProduct();

        if (p == null) return;
        int existingQty = p.getQuantity();
        BigDecimal existingPrice = p.getPrice();

        p = view.updateProduct(p);

        if (Objects.equals(existingPrice, p.getPrice()) && existingQty == p.getQuantity()) {
            view.displayMessage("Product unchanged");
            view.pressEnterToContinue();
            return;
        }
        InventoryResult result = service.update(p);

        if (result.isSuccess()) {
            view.displayMessage("Product " + result.getProduct().getProductName() + " updated successfully!");

        } else {
            view.displayErrors(result.getErrorMessages());
        }
        view.pressEnterToContinue();
    }

    public void deleteProduct() throws DataAccessException {
        view.displayHeader("Delete Product");
        Product p = getSingleProduct();
        if (p == null) return;

        view.displayMessage("Product to delete:");
        view.displayMessage(p.toString());

        p = view.deleteProduct(p);
        if (p == null) {
            view.displayMessage("Product not deleted");
            view.pressEnterToContinue();
            return;
        }

        InventoryResult result = service.deleteById(p.getProductID());

        if (result.isSuccess()) {
            view.displayMessage("Product `" + p.getProductName() + "` deleted successfully!");

        } else {
            view.displayErrors(result.getErrorMessages());
        }
        view.pressEnterToContinue();
    }

    // method for partial search that returns a list of products from search
    private List<Product> getProductsWithPartialSearch() {
        return view.searchProducts(service.getAvailableInventory());
    }

    //  method for update/delete operations that need a single product
    private Product getSingleProduct() {
        List<Product> foundProducts = getProductsWithPartialSearch();

        if (foundProducts.isEmpty()) {
            view.displayMessage("No products found matching your search.");
            view.pressEnterToContinue();
            return null;
        }

        if (foundProducts.size() == 1) {
            return foundProducts.getFirst();
        }

        // If multiple products found, let user choose from the list
        view.displayMessage("Multiple products found. Please choose one:");
        return view.chooseFromProducts(foundProducts);
    }
}