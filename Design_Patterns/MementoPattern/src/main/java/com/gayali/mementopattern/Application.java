package com.gayali.mementopattern;

public class Application {
    
    public static void main(String[] args){
        
    CareTaker careTaker= new CareTaker();
    Cart cart =new Cart();
    
    cart.addItem(new Item("Book"));
    cart.addItem(new Item("Pen"));
    
    careTaker.save(cart);
    System.out.println(cart);
    
    cart.addItem(new Item("Pencil"));
    careTaker.save(cart);
    System.out.println(cart);
    cart.addItem(new Item("Phone"));
    careTaker.save(cart);
    System.out.println(cart);
    cart.addItem(new Item("noteBook"));
    //careTaker.save(cart);
    System.out.println(cart);
    
    careTaker.revert(cart); 
    System.out.println(cart);
     
    cart.addItem(new Item("Ipad"));
    //careTaker.save(cart);
    System.out.println(cart);
    
    careTaker.revert(cart); 
    System.out.println(cart);
    careTaker.revert(cart); 
    System.out.println(cart);
    careTaker.revert(cart); 
    System.out.println(cart);
    careTaker.revert(cart); 
    System.out.println(cart);
    careTaker.revert(cart); 
    System.out.println(cart);
    
    }
    
}
