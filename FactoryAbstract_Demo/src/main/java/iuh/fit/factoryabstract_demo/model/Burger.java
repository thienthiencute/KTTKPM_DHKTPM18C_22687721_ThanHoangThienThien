package iuh.fit.factoryabstract_demo.model;

import iuh.fit.factoryabstract_demo.model.implement.MainDish;

public class Burger implements MainDish {
    @Override
    public String cook() {
        return "Cooking burger";
    }
}
