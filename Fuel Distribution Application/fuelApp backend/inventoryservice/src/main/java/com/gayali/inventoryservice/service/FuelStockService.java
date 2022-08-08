package com.gayali.inventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gayali.inventoryservice.model.FuelStock;
import com.gayali.inventoryservice.repository.FuelStockRepository;

@Service
public class FuelStockService {
	
	@Autowired
	FuelStockRepository fuelStockRepo;
	
	
	public FuelStock saveFuelStock(FuelStock fuelStock) {
		
		
		return fuelStockRepo.save(fuelStock);
		
		
	}
	
	
}
