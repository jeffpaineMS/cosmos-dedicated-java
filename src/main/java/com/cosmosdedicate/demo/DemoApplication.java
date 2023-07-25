package com.cosmosdedicate.demo;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private ProductRepository productsRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	public void run(String... var1) {
		var ids = List.of("fc9e4baa-1457-43c5-967a-8faa10fcc7aa");

		var results = productsRepo.findAllByIdIn(ids);
		LOGGER.info("count of items found: {}", results.size());
	}
}
