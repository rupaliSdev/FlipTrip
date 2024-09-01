package com.LLD.AddOnFeatures;

public class DrinkService implements AddOnService{
    @Override
    public String getDescription() {
        return "Drink Service";
    }

    @Override
    public double getPrice() {
        return 50.00;
    }
}
