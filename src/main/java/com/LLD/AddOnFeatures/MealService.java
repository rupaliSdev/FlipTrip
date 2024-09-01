package com.LLD.AddOnFeatures;

public class MealService implements AddOnService {

    @Override
    public String getDescription() {
        return "MealService";
    }

    @Override
    public double getPrice() {
        return 100;
    }
}
