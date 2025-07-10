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
        for (int option = view.chooseMenuOption(); option < 6; option = view.chooseMenuOption()) {

            switch (option) {
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
        Product p = getProduct();

        if (p == null) return;

        view.displayMessage("Product Found:");
        view.displayMessage(p.toString());
        view.pressEnterToContinue();
    }


    private void updateProduct() throws DataAccessException {
        view.displayHeader("Update Product");
        Product p = getProduct();

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
        Product p = getProduct();
        if (p == null) return;

        view.displayMessage("Product to delete:");
        view.displayMessage(p.toString());

        p = view.deleteProduct(p);
        if (p == null) {
            view.displayMessage("Product not deleted");
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

    private Product getProduct() {
        Product p = view.chooseProduct(service.getAvailableInventory());

        if (p == null) {
            view.displayMessage("Product not found.");
            view.pressEnterToContinue();
            return null;
        }
        return p;
    }
}