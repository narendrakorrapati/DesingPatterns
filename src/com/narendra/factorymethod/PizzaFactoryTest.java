package com.narendra.factorymethod;

public class PizzaFactoryTest {

    public static void main(String[] args) {
        PizzaStore nyStore = new NewYorkPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        nyStore.orderPizza("cheese");
        nyStore.orderPizza("veg");

        chicagoStore.orderPizza("cheese");
        chicagoStore.orderPizza("veg");
    }
}

/**
 * Creator
 */
abstract class PizzaStore {
    void orderPizza(String type) {
       Pizza pizza = createPizza(type);
       pizza.bake();
    }

    //Subclass decide how to instantiate
    abstract Pizza createPizza(String type);
}

/**
 * Concrete Creator 1
 */
class NewYorkPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if("cheese".equals(type)) {
            return new NYCheesePizza();
        } else if("veg".equals(type)) {
            return new NYVegPizza();
        } else {
            throw new RuntimeException("Invalid Pizza type");
        }
    }
}

/**
 * Concrete Creator 2
 */
class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if("cheese".equals(type)) {
            return new ChicagoCheesePizza();
        } else if("veg".equals(type)) {
            return new ChicagoVegPizza();
        } else {
            throw new RuntimeException("Invalid Pizza type");
        }
    }
}

/**
 * Product
 */
abstract class Pizza {
    String name;

    void bake() {
        System.out.println("Baking " + name);
    }
}

/**
 * Concrete Product 1
 */
class NYCheesePizza extends Pizza {

    NYCheesePizza() {
        super.name = "NYCheesePizza";
    }
}
/**
 * Concrete Product 2
 */
class NYVegPizza extends Pizza {

    NYVegPizza() {
        super.name = "NYVegPizza";
    }
}

/**
 * Concrete Product 3
 */
class ChicagoVegPizza extends Pizza {

    ChicagoVegPizza() {
        super.name = "ChicagoVegPizza";
    }
}

/**
 * Concrete Product 4
 */
class ChicagoCheesePizza extends Pizza {

    ChicagoCheesePizza() {
        super.name = "ChicagoCheesePizza";
    }
}