package iuh.fit.factoryabstract_demo.factory;

import iuh.fit.factoryabstract_demo.model.Cola;
import iuh.fit.factoryabstract_demo.model.Pizza;
import iuh.fit.factoryabstract_demo.model.implement.Drink;
import iuh.fit.factoryabstract_demo.model.implement.MainDish;
import iuh.fit.factoryabstract_demo.model.implement.MealFactory;

public class PizzaMealFactory implements MealFactory {
    @Override
    public MainDish createMainDish() {
        return new Pizza();
    }

    @Override
    public Drink createDrink() {
        return new Cola();
    }
}
