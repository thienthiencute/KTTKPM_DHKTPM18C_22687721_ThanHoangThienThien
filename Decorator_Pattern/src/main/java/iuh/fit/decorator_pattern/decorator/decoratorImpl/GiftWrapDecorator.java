package iuh.fit.decorator_pattern.decorator.decoratorImpl;

import iuh.fit.decorator_pattern.decorator.Order;

public class GiftWrapDecorator extends OrderDecorator{
    public GiftWrapDecorator(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return order.getDescription() + ", Gift Wrapped";
    }

    @Override
    public double getCost() {
        return order.getCost() + 5.0; // phí gói quà
    }
}

