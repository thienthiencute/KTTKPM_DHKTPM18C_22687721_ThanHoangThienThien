package iuh.fit.strategypattern_demo.strategy.strategyImplement;

import iuh.fit.strategypattern_demo.strategy.ShippingStrategy;

public class FreeShipping implements ShippingStrategy {
    @Override
    public double calculate(double orderAmount) {
        return 0; // miễn phí
    }
}
