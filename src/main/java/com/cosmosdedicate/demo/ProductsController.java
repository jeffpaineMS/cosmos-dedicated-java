package com.cosmosdedicate.demo;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.cosmos.models.PartitionKey;

@RestController
@RequestMapping(value = "api/products")
public class ProductsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    private ProductRepository repository;

    @Autowired

    @GetMapping(value = "/in", produces = { "application/json" })
    public ResponseEntity getByIds() {
        var ids = List.of("fc9e4baa-1457-43c5-967a-8faa10fcc7aa");

        var results = repository.findAllByIdIn(ids);
        LOGGER.info("count of items found: {}", results.size());

        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity getByIds(@PathVariable String id) {

        var results = repository.findById(id, new PartitionKey(id));

        LOGGER.info("count of items found: {}", results.isPresent());

        return ResponseEntity.accepted().build();
    }

}
