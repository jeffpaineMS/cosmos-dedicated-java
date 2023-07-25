package com.cosmosdedicate.demo;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import java.util.List;

@Repository
public interface StoreRepository extends CosmosRepository<Store, String> {
    List<Store> findAllByIdIn(List<String> ids);
}
