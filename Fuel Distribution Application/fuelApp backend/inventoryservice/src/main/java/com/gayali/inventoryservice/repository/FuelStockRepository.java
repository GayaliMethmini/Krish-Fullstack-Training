package com.gayali.inventoryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gayali.inventoryservice.model.FuelStock;

public interface FuelStockRepository  extends MongoRepository<FuelStock, String>{

}
