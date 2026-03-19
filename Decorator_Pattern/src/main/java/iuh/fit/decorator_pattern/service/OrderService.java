package iuh.fit.decorator_pattern.service;

import iuh.fit.decorator_pattern.decorator.Order;
import iuh.fit.decorator_pattern.decorator.decoratorImpl.BasicOrder;
import iuh.fit.decorator_pattern.decorator.decoratorImpl.ExtraToppingDecorator;
import iuh.fit.decorator_pattern.decorator.decoratorImpl.GiftWrapDecorator;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public Order createBasicOrder() {
        return new BasicOrder();
    }

    public Order addGiftWrap(Order order) {
        return new GiftWrapDecorator(order);
    }

    public Order addExtraTopping(Order order) {
        return new ExtraToppingDecorator(order);
    }
}
