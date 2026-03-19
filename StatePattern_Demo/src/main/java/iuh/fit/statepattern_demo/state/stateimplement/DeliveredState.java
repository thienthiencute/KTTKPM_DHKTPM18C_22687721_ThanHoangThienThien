package iuh.fit.statepattern_demo.state.stateimplement;

import iuh.fit.statepattern_demo.state.OrderState;

public class DeliveredState implements OrderState {
    @Override
    public String nextState(OrderContext context) {
        return "Order already Delivered, cannot move further";
    }
}
