package com.learn.inventory_manager;

import com.learn.inventory_manager.data.InventoryRepository;
import com.learn.inventory_manager.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class InventoryManagerApplication implements CommandLineRunner {
	@Autowired
	InventoryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Product> products = repository.getAll();

		products.forEach(product -> {
			System.out.printf("Product ID: %d%n", product.getProductID());
			System.out.printf("Product Name: %s%n", product.getProductName());
			System.out.printf("Qty: %d%n", product.getQuantity());
			System.out.printf("Price: %s%n%n", product.getPrice());
		});

		Product p = repository.findById("10");
		System.out.println(p.toString());
	}
}
