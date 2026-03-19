package iuh.fit.statepattern_demo.service;

import iuh.fit.statepattern_demo.state.stateimplement.OrderContext;
import org.springframework.stereotype.Service;
@Service
public class OrderService {
    private final OrderContext orderContext = new OrderContext();

    public String nextOrderState() {
        return orderContext.nextState();
    }
}
