package com.gayali.mementopattern;

import java.util.ArrayList;

public class Cart {
    
    ArrayList<Item> items =new ArrayList<>();
    
    public void addItem(Item item){
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return (ArrayList)items.clone();
    }

    public CartMomemnto save(){
        return new CartMomemnto(getItems());
    }
    
    public void revert(CartMomemnto cartMomento){
        items=cartMomento.getItems();
    }
    
    @Override
    public String toString() {
        return "CareTaker{" + "items=" + items + '}';
    }
    
    static class CartMomemnto{
        
        ArrayList<Item> items;
    
        public CartMomemnto(ArrayList<Item> items){
            this.items=items;
        }

        private ArrayList<Item> getItems() {
            return items;
        }
    
    }
    
}
