package com.gayali.prototypepattern;

public class Bus extends Vehicle{
    
    private int numberofSeats;

    public int getNumberofSeats() {
        return numberofSeats;
    }

    public void setNumberofSeats(int numberofSeats) {
        this.numberofSeats = numberofSeats;
    }

    @Override
    public String toString() {
        return "Bus{" + "numberofSeats=" + numberofSeats + '}';
    }
}
