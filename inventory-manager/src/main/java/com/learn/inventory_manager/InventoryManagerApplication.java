package com.learn.inventory_manager;

import com.learn.inventory_manager.repository.DataAccessException;
import com.learn.inventory_manager.service.InventoryService;
import com.learn.inventory_manager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class InventoryManagerApplication implements CommandLineRunner {
	@Autowired
	private InventoryService inventoryService;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws DataAccessException {
		System.out.println("=== Inventory Manager ===");

		List<Product> productList = inventoryService.getAvailableInventory();
		displayProducts(productList);
		System.out.println(inventoryService.getProductById("2").toString());
		System.out.println(inventoryService.getProductByName("keyboard").toString());
		System.out.println(inventoryService.deleteById("2").isSuccess());
		System.out.println(inventoryService.deleteById("2").isSuccess());
		System.out.println(inventoryService.deleteById("2").getErrorMessages());

		productList = inventoryService.getAvailableInventory();
		displayProducts(productList);

		Product newProduct = new Product("2", "Phone", 5, new BigDecimal("1249.99"));
		inventoryService.add(newProduct);
		newProduct.setQuantity(newProduct.getQuantity() + 19);
		inventoryService.update(newProduct);
		productList = inventoryService.getAvailableInventory();

		displayProducts(productList);


	}

	private static void displayProducts(List<Product> productList) {
		System.out.println("Total Products: " + productList.size());
		System.out.println();

		for (Product product : productList) {
			System.out.println(product.toString());
			System.out.println();
		}
	}

}
