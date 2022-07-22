package com.gayali.builderpattern;

public class Application {
    
    public static void  main(String[] args){
    
        CarTelescopic1 carteles1=new CarTelescopic1("full");
        
        System.out.println(carteles1);
        
         CarTelescopic2 carteles2= new CarTelescopic2("full");
        
        System.out.println(carteles2);
        
        
        Car.Builder builder = new Car.Builder("full");
        
        Car car = builder.dropOffLocation("LA").roadAssistance("full").build();
        
        System.out.println(car);
    
    }
}
