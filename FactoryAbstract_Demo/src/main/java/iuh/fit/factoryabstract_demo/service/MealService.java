package iuh.fit.factoryabstract_demo.service;


import iuh.fit.factoryabstract_demo.factory.BurgerMealFactory;
import iuh.fit.factoryabstract_demo.factory.PizzaMealFactory;
import iuh.fit.factoryabstract_demo.model.implement.Drink;
import iuh.fit.factoryabstract_demo.model.implement.MainDish;
import iuh.fit.factoryabstract_demo.model.implement.MealFactory;
import org.springframework.stereotype.Service;

@Service
public class MealService {
    public String orderMeal(String type) {
        MealFactory factory;

        if (type.equalsIgnoreCase("pizza")) {
            factory = new PizzaMealFactory();
        } else if (type.equalsIgnoreCase("burger")) {
            factory = new BurgerMealFactory();
        } else {
            throw new IllegalArgumentException("Unknown meal type: " + type);
        }

        MainDish main = factory.createMainDish();
        Drink drink = factory.createDrink();

        return main.cook() + " + " + drink.serve() +
                " (Main hash: " + main.hashCode() + ", Drink hash: " + drink.hashCode() + ")";
    }

}
