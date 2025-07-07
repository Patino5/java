package com.learn.inventory_manager.config;

import com.learn.inventory_manager.repository.CSVInventoryRepository;
import com.learn.inventory_manager.repository.InventoryRepository;
import com.learn.inventory_manager.repository.SampleInventoryRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {
    // load from application.properties, with a default sample if value missing
    @Value("${inventory.repository.source:sample}")
    private String repositorySource;

    // create the appropriate repository based on source
    @Bean
    public InventoryRepository inventoryRepository() {
        switch (repositorySource.toLowerCase()) {
            case "csv":
                System.out.println("Configuring CSV Inventory Repository");
                return new CSVInventoryRepository();
            case "sample":
            default:
                System.out.println("Configuring Sample Inventory Repository");
                return new SampleInventoryRepository();
        }
    }
}
