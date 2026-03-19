package iuh.fit.decorator_pattern.decorator.decoratorImpl;

import iuh.fit.decorator_pattern.decorator.Order;

public abstract class OrderDecorator implements Order {
    protected final Order order;

    public OrderDecorator(Order order) {
        this.order = order;
    }

    @Override
    public String getDescription() {
        return order.getDescription();
    }

    @Override
    public double getCost() {
        return order.getCost();
    }
}
