package com.learn.inventory_manager.ui;

import com.learn.inventory_manager.model.Product;
import com.learn.inventory_manager.repository.DataAccessException;
import com.learn.inventory_manager.service.InventoryResult;
import com.learn.inventory_manager.service.InventoryService;
import org.springframework.stereotype.Component;

import java.util.List;

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
                case 4 -> updateProduct();
            }
        }
    }

    private void viewProducts() throws DataAccessException {
        List<Product> products = service.getAvailableInventory();
        view.displayProducts(products);
    }

    private void addProduct() throws DataAccessException {
        Product p = view.createProduct();
        InventoryResult result = service.add(p);
        if (result.isSuccess()) {
            view.displayMessage("Product " + result.getProduct().getProductName() + " added.");
        } else {
            view.displayErrors(result.getErrorMessages());
        }
    }

    private void updateProduct() throws DataAccessException {
        Product p = view.chooseProduct(service.getAvailableInventory());

        if (p == null) {
            view.displayMessage("Product not found.");
            return;
        }

        p = view.updateProduct(p);
        InventoryResult result = service.update(p);

        if (result.isSuccess()) {
            view.displayMessage("Product " + result.getProduct().getProductName() + " updated successfully!");

        } else view.displayErrors(result.getErrorMessages());
    }

}