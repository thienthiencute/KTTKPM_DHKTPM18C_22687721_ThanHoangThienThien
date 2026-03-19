package iuh.fit.strategypattern_demo.strategy.strategyImplement;

import iuh.fit.strategypattern_demo.strategy.ShippingStrategy;

public class ShippingContext {
    private ShippingStrategy strategy;

    public ShippingContext(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateShipping(double amount) {
        return strategy.calculate(amount);
    }
}
