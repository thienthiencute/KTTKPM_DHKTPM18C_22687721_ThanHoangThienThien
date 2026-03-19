package iuh.fit.factoryabstract_demo.factory;

import iuh.fit.factoryabstract_demo.model.Burger;
import iuh.fit.factoryabstract_demo.model.Juice;
import iuh.fit.factoryabstract_demo.model.implement.Drink;
import iuh.fit.factoryabstract_demo.model.implement.MainDish;
import iuh.fit.factoryabstract_demo.model.implement.MealFactory;

public class BurgerMealFactory implements MealFactory {
    @Override
    public MainDish createMainDish() {
        return new Burger();
    }

    @Override
    public Drink createDrink() {
        return new Juice();
    }
}
