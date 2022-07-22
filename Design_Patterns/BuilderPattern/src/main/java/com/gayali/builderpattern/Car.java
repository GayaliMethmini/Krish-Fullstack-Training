package com.gayali.builderpattern;

public class Car {

    private final String insurnace;
    private final Boolean etc;
    private final String roadAssistance;
    private final String dropOffLocation;
    
    public Car (Builder builder){
        
        this.insurnace =builder.insurnace;
        this.dropOffLocation=builder.dropOffLocation;
        this.etc=builder.etc;
        this.roadAssistance=builder.roadAssistance;
    
    }
     
    static class Builder{
    
        private String insurnace;
        private Boolean etc;
        private String roadAssistance;
        private String dropOffLocation;
    
        public Car build(){
            return new Car(this);
    
        }
    
        public Builder(String insurnace) {
            this.insurnace=insurnace; 
            
        }
    
        public Builder etc(Boolean etc){
            this.etc=etc;
            return this;
        }
        public Builder roadAssistance(String roadAssistance){
            this.roadAssistance=roadAssistance;
            return this;
        }
        public Builder dropOffLocation(String dropOffLocation){
            this.dropOffLocation=dropOffLocation;
            return this;
        }
    
    }

    @Override
    public String toString() {
        return "Car{" + "insurnace=" + insurnace + ", etc=" + etc + ", roadAssistance=" + roadAssistance + ", dropOffLocation=" + dropOffLocation + '}';
    }
    
}
