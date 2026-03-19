package iuh.fit.strategypattern_demo.strategy.strategyImplement;

import iuh.fit.strategypattern_demo.strategy.ShippingStrategy;

public class NormalShipping implements ShippingStrategy {
    @Override
    public double calculate(double orderAmount) {
        return orderAmount * 0.05; // 5% phí vận chuyển
    }
}
