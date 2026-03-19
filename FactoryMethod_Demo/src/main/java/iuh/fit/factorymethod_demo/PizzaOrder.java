package iuh.fit.factorymethod_demo;

public class PizzaOrder implements Order{
    @Override
    public String prepare() {
        return "Preparing a delicious pizza!";
    }
}
