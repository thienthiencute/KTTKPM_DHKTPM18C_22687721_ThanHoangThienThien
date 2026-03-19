package iuh.fit.statepattern_demo.state.stateimplement;

import iuh.fit.statepattern_demo.state.OrderState;

public class ConfirmedState implements OrderState {
    @Override
    public String nextState(OrderContext context) {
        context.setState(new DeliveredState());
        return "Order moved from Confirmed → Delivered";
    }
}
