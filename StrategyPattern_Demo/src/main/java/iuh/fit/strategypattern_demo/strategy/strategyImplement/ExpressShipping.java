package iuh.fit.strategypattern_demo.strategy.strategyImplement;

import iuh.fit.strategypattern_demo.strategy.ShippingStrategy;

public class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculate(double orderAmount) {
        return orderAmount * 0.1 + 20; // 10% + phí cố định
    }
}
