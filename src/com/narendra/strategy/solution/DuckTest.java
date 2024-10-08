package com.narendra.strategy.solution;

/*
1. Extract commonly changing behaviour and encapsulate it
2. Add a composition in Duck abstract class with the Behaviours.
3. Change methods from fly() to performFly() and quack to performQuack()
4. Call composition provided methods inside perform methods.
5. Add setter methods to change behaviours dynamically at runtime.
6. Assign behaviour to abstract class when creating a concrete class (in side constructor).
7. Create object for concrete class and call perform methods.
 */
public class DuckTest {

    public static void main(String[] args) {
        Duck mallar = new MallarDuck();

        mallar.performFly();
        mallar.performQuack();
        mallar.swim();
        mallar.display();

        Duck rubber = new RubberDuck();
        rubber.performFly();
        rubber.performQuack();
        rubber.swim();
        rubber.display();

        //Change the behaviour of rubber duck at runtime.
        System.out.println("Changing the behaviour of rubber duck at runtime");
        rubber.setFlyBehaviour(new FlyWithRocket());
        rubber.setQuackBehaviour(new Quack());
        rubber.performFly();
        rubber.performQuack();

    }
}
