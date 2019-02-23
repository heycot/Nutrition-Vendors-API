package com.example.nutritionVendors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class NutritionVendorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritionVendorsApplication.class, args);
	}

}
