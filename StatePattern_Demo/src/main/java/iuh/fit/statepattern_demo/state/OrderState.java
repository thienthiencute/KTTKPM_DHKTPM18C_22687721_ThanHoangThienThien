package iuh.fit.statepattern_demo.state;

import iuh.fit.statepattern_demo.state.stateimplement.OrderContext;

public interface OrderState {
    String nextState(OrderContext context);
}
