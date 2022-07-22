package com.designpattern.factorypattern;

public class Application {
    public static void main(String[] args){
    
        Package aPackage=PackageFactory.createPackage(PackageCode.BASIC);
        System.out.println(aPackage);
        
        Package bPackage=PackageFactory.createPackage(PackageCode.PLATINUM);
        System.out.println(bPackage);
    
    }
}
