package iuh.fit.decorator_pattern.decorator.decoratorImpl;

import iuh.fit.decorator_pattern.decorator.Order;

public class ExtraToppingDecorator extends OrderDecorator {
    public ExtraToppingDecorator(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return order.getDescription() + ", Extra Topping";
    }

    @Override
    public double getCost() {
        return order.getCost() + 10.0; // phí topping
    }
}
