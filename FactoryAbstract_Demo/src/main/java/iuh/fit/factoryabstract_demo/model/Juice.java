package iuh.fit.factoryabstract_demo.model;

import iuh.fit.factoryabstract_demo.model.implement.Drink;

public class Juice implements Drink {
    @Override
    public String serve() {
        return "Serving Juice";
    }
}
