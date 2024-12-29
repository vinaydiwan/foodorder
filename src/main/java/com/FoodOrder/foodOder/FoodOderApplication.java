package com.FoodOrder.foodOder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FoodOderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOderApplication.class, args);
	}

}
