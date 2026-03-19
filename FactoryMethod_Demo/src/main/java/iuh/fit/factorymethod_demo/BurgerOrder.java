package iuh.fit.factorymethod_demo;

public class BurgerOrder implements Order {
    @Override
    public String prepare() {
        return "Preparing a juicy burger!";
    }
}
