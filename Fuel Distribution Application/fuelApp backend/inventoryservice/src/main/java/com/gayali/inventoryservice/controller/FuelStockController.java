package com.gayali.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gayali.inventoryservice.model.FuelStock;
import com.gayali.inventoryservice.service.FuelStockService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/fuelstock")
public class FuelStockController {
	
	@Autowired
	FuelStockService fuelStockService;
	
	@PostMapping("/")
	public FuelStock saveFuelStock(@RequestBody FuelStock fuelStock) {
		
		return fuelStockService.saveFuelStock(fuelStock);
		
	}
	

}
