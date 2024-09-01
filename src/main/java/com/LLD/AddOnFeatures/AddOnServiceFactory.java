package com.LLD.AddOnFeatures;

public class AddOnServiceFactory {

    public static AddOnService getAddOnService(String addOn) {
        switch (addOn.toLowerCase()) {
            case "baggage":
                new ExcessBaggageService();
            case "drink":
                new DrinkService();
            case "meal":
                return new MealService();
            default:
                return new NoService();
        }
    }
}
