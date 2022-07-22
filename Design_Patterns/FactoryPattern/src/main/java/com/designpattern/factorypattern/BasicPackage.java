package com.designpattern.factorypattern;

public class BasicPackage extends Package {
    @Override
     protected  void createPackage(){
     
     decorations.add(new BridalDeco());
     
     };
    
}
