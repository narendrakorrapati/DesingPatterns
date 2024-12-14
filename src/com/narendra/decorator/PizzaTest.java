package com.narendra.decorator;

public class PizzaTest {

    public static void main(String[] args) {

        Pizza pizza = new BasePizza();
        //System.out.println(pizza.bake());

        pizza = new CheeseDecorator(pizza);
        //System.out.println(pizza.bake());

        pizza = new OnionDecorator(pizza);
        System.out.println(pizza.bake());

    }
}

interface Pizza {
    String bake();
}

class PizzaDecorator implements Pizza{

    Pizza pizza;

    PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String bake() {
        return pizza.bake();
    }
}

class BasePizza implements Pizza{

    @Override
    public String bake() {
        return "Base Pizza";
    }
}

class CheeseDecorator extends PizzaDecorator {

    CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bake() {
        return  super.bake() + "-Cheese";
    }
}

class OnionDecorator extends PizzaDecorator {

    OnionDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bake() {
        return  super.bake() + "-Onion";
    }
}

class ChickenDecorator extends PizzaDecorator {

    ChickenDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bake() {
        return  super.bake() + "-Chicken";
    }
}