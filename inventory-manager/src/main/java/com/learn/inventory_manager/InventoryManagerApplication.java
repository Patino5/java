package com.learn.inventory_manager;

import com.learn.inventory_manager.service.InventoryService;
import com.learn.inventory_manager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@SpringBootApplication
public class InventoryManagerApplication implements CommandLineRunner {
	@Autowired
	private InventoryService inventoryService;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== Inventory Manager ===");

		List<Product> productList = inventoryService.getAvailableInventory();
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
