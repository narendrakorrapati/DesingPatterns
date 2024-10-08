package com.narendra.strategy.solution;

public abstract class Duck {

    QuackBehaviour quackBehaviour;
    FlyBehaviour flyBehaviour;

    void performQuack() {
        quackBehaviour.quack();
    }

    void performFly() {
        flyBehaviour.fly();
    }

    void swim() {
        System.out.println("Swimming");
    }

    public void setQuackBehaviour(QuackBehaviour qb) {
        quackBehaviour = qb;
    }

    public void setFlyBehaviour(FlyBehaviour fb) {
        flyBehaviour = fb;
    }

    abstract void display();
}
