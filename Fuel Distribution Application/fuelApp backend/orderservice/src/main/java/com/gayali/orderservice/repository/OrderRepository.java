package com.gayali.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gayali.orderservice.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String>{

}
