package com.learn.inventory_manager;

import com.learn.inventory_manager.repository.DataAccessException;
import com.learn.inventory_manager.service.InventoryService;
import com.learn.inventory_manager.ui.ConsoleIO;
import com.learn.inventory_manager.ui.Controller;
import com.learn.inventory_manager.ui.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class InventoryManagerApplication implements CommandLineRunner {

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private Controller controller;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws DataAccessException {
		controller.run();
	}
}
