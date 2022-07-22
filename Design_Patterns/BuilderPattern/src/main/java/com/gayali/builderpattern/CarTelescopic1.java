package com.gayali.builderpattern;

public class CarTelescopic1 {
    
    String insurnace;
    Boolean etc;
    String roadAssistance;
    String dropOffLocation;

    public CarTelescopic1(String insurnace) {
        this.insurnace = insurnace;
    }

    public CarTelescopic1(String insurnace, Boolean etc) {
        this(insurnace);
        this.etc = etc;
    }

    public CarTelescopic1(String insurnace, Boolean etc, String roadAssistance) {
        this(insurnace,etc);
        this.roadAssistance = roadAssistance;
    }

    public CarTelescopic1(String insurnace, Boolean etc, String roadAssistance, String dropOffLocation) {
        this(insurnace,etc,roadAssistance);
        this.dropOffLocation = dropOffLocation;
    }

    @Override
    public String toString() {
        return "CarTelescopic1{" + "insurnace=" + insurnace + ", etc=" + etc + ", roadAssistance=" + roadAssistance + ", dropOffLocation=" + dropOffLocation + '}';
    }
    
}
