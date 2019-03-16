package com.example.nutritionVendors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableJpaRepositories("com.example.nutritionVendors.respositories")
@EntityScan(basePackages = {"com.example.nutritionVendors.entities", "com.example.nutritionVendors.entitiesDTO"})
@Configuration
public class NutritionVendorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritionVendorsApplication.class, args);
	}

}
