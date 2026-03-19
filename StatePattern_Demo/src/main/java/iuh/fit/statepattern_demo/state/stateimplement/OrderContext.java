package iuh.fit.statepattern_demo.state.stateimplement;

import iuh.fit.statepattern_demo.state.OrderState;

public class OrderContext {
    private OrderState state = new PendingState(); // trạng thái mặc định

    public void setState(OrderState state) { this.state = state; }
    public String nextState() { return state.nextState(this); }
}
