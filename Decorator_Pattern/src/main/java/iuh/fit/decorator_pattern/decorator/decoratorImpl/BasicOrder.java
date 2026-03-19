package iuh.fit.decorator_pattern.decorator.decoratorImpl;

import iuh.fit.decorator_pattern.decorator.Order;

public class BasicOrder implements Order {
    @Override
    public String getDescription() {
        return "Basic Order";
    }

    @Override
    public double getCost() {
        return 50.0; // phí cơ bản
    }
}
