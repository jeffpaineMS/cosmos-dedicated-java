package com.cosmosdedicate.demo;

import java.util.List;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

public interface ProductRepository extends CosmosRepository<Product, String> {

    List<Product> findAllByIdIn(List<String> ids);

}
