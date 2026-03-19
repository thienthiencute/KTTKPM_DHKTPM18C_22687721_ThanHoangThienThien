package iuh.fit.factorymethod_demo;

public class OrderFactory {
    public static Order createOrder(String type) {
        if (type.equalsIgnoreCase("pizza")) {
            return new PizzaOrder();
        } else if (type.equalsIgnoreCase("burger")) {
            return new BurgerOrder();
        } else {
            throw new IllegalArgumentException("Unknown order type: " + type);
        }
    }
}
