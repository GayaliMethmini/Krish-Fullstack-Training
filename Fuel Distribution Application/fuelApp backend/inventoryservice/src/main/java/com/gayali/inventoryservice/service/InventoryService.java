package com.gayali.inventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gayali.inventoryservice.model.FuelStock;
import com.gayali.inventoryservice.model.Order;
import com.gayali.inventoryservice.repository.FuelStockRepository;
import com.gayali.inventoryservice.repository.OrderRepository;

@Service
public class InventoryService {
	
	@Value("${order.topic.name}")
	  private String orderTopicName;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	FuelStockRepository fuelStockRepo;
	
	 ObjectMapper objm = new ObjectMapper();
	 
	 @KafkaListener(topics = "orderService-topic", groupId = "reserved")
	 public void reservedStock(String message) {
		 
		    System.out.println("Message is recieved to group reserved: " + message);
		   
		    
		    try {
		      Order order = objm.readValue(message, Order.class);
		      FuelStock stock = fuelStockRepo.findById(order.getFuelId()).get();
			    if (stock.getFuelCapacity() > order.getFuelCapacity()) {
			      stock.setFuelCapacity(stock.getFuelCapacity() - order.getFuelCapacity());
			      order.setOrderStatus("FUEL ALLOCATION COMPLETED");
			      orderRepo.save(order);
			      fuelStockRepo.save(stock);		     
			    
			    } else {
			      order.setOrderStatus("FUEL ALLOCATION FAILED");
			      orderRepo.save(order);			     
			    }    
			   
		    } catch (JsonProcessingException e) {
		      e.printStackTrace();
		    }
		    

		  }
	

}
