package iuh.fit.factoryabstract_demo.model;

import iuh.fit.factoryabstract_demo.model.implement.Drink;

public class Cola implements Drink {
    @Override
    public String serve() {
        return "Serving Cola";
    }
}
