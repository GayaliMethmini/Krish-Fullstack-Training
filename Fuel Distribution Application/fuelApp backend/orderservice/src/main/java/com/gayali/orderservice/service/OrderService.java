package com.gayali.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gayali.orderservice.model.Order;
import com.gayali.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	KafkaTemplate<String,String> kafkaTemplate;
	
	@Value("${order.topic.name}")
	private String orderTopicName;
	
	ObjectMapper objm=new ObjectMapper();
	
	public Order saveOrder(Order order) {
		
		order.setOrderStatus("ORDER IS CREATED");
		order = orderRepo.save(order);
		
		String orderMessage= null;
	    try {
	      orderMessage = objm.writeValueAsString(order);
	    } catch (JsonProcessingException e) {
	      e.printStackTrace();
	    }
	    kafkaTemplate.send(orderTopicName,orderMessage);
		
		return order;
	}

}
