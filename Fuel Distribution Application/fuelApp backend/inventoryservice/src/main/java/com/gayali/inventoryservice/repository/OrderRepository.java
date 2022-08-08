package com.gayali.inventoryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gayali.inventoryservice.model.Order;

public interface OrderRepository extends MongoRepository<Order,String> {

}
