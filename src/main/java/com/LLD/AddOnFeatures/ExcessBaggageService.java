package com.LLD.AddOnFeatures;

public class ExcessBaggageService implements AddOnService {


    @Override
    public String getDescription() {
        return "Excess Baggage";
    }

    @Override
    public double getPrice() {
        return 2000;
    }
}
