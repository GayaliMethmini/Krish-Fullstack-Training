package com.gayali.prototypepattern;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registry {
    
    private Map<VehicleType, Vehicle> vehicles=new HashMap<>();

    public Registry() {
      this.initialize();
        
    }
    
    public Vehicle getVehicle(VehicleType vehicleType){
        
        Vehicle vehicle= null;
    
        try {
            vehicle = (Vehicle) vehicles.get(vehicleType).clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Registry.class.getName()).log(Level.SEVERE, null, ex);
        }
    return vehicle;
    }
    
    private void initialize(){
        
        Car car = new Car();
        car.setEngineCapacity(200);
        car.setFuelType("Gasoline");
        car.setType("Mini");
        
        Bus bus = new Bus();
        bus.setEngineCapacity(3000);
        bus.setFuelType("Diesal");
        bus.setNumberofSeats(32);
        
        vehicles.put(VehicleType.CAR,car);
        vehicles.put(VehicleType.BUS,bus);
        
    }
}
