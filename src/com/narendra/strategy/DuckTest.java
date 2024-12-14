package com.narendra.strategy;

public class DuckTest {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        Duck rubberDuck = new RubberDuck();
        Duck woodenDuck = new WoodenDuck();

        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.display();

        rubberDuck.performFly();
        rubberDuck.performQuack();
        rubberDuck.display();

        woodenDuck.performFly();
        woodenDuck.performQuack();
        woodenDuck.display();

        woodenDuck.setFlyBehaviour(new FlyWithWings());
        woodenDuck.performFly();
    }
}

abstract class Duck {

    FlyBehaviour flyBehaviour;
    QuackBehavior quackBehavior;
    void swim() {
        System.out.println("Swimming");
    }

    void performFly() {
        flyBehaviour.fly();
    }
    void performQuack() {
        quackBehavior.quack();
    }
    abstract void display();

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}

interface FlyBehaviour {
    void fly();
}

interface QuackBehavior {
    void quack();
}

class FlyWithWings implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("Flying with wings");
    }
}

class FlyNoWay implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("Can't fly");
    }
}

class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}

class Squeeze implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeeze");
    }
}

class NoQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("No Quack");
    }
}

class MallardDuck extends Duck {

    MallardDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    void display() {
        System.out.println("I am a MallardDuck");
    }
}

class ReadHeadedDuck extends Duck {

    ReadHeadedDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    void display() {
        System.out.println("I am a ReadHeadedDuck");
    }
}

class RubberDuck extends Duck{

    RubberDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehavior = new Squeeze();
    }
    @Override
    void display() {
        System.out.println("I am a RubberDuck");
    }
}

class WoodenDuck extends Duck {

    WoodenDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehavior = new NoQuack();
    }

    @Override
    void display() {
        System.out.println("I am a WoodenDuck");
    }
}