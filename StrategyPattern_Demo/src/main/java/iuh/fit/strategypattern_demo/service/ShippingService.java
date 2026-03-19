package iuh.fit.strategypattern_demo.service;

import iuh.fit.strategypattern_demo.strategy.strategyImplement.ExpressShipping;
import iuh.fit.strategypattern_demo.strategy.strategyImplement.FreeShipping;
import iuh.fit.strategypattern_demo.strategy.strategyImplement.NormalShipping;
import iuh.fit.strategypattern_demo.strategy.strategyImplement.ShippingContext;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    private final ShippingContext context = new ShippingContext(new NormalShipping());

    public double calculate(String type, double amount) {
        switch (type.toLowerCase()) {
            case "normal":
                context.setStrategy(new NormalShipping());
                break;
            case "express":
                context.setStrategy(new ExpressShipping());
                break;
            case "free":
                context.setStrategy(new FreeShipping());
                break;
            default:
                throw new IllegalArgumentException("Unknown shipping type: " + type);
        }
        return context.calculateShipping(amount);
    }
}
