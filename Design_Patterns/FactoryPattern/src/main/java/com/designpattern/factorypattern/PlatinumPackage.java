package com.designpattern.factorypattern;

public class PlatinumPackage extends Package{
    @Override
     protected  void createPackage(){
     decorations.add(new FlowerGirlDeco()); 
     decorations.add(new ParentDeco());   
     decorations.add(new BridalDeco());
     decorations.add(new BridesMaidDeco());
     };
}
