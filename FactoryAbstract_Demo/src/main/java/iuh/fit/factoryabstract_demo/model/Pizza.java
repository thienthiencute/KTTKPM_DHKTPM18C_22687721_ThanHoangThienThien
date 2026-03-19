package iuh.fit.factoryabstract_demo.model;

import iuh.fit.factoryabstract_demo.model.implement.MainDish;

public class Pizza implements MainDish {
    @Override
    public String cook() {
        return "Cooking Pizza";
    }
}
