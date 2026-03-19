package iuh.fit.statepattern_demo.state.stateimplement;

import iuh.fit.statepattern_demo.state.OrderState;

public class PendingState implements OrderState {
    @Override
    public String nextState(OrderContext context) {
        context.setState(new ConfirmedState());
        return "Order moved from Pending → Confirmed";
    }
}
