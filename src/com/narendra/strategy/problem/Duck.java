package com.narendra.strategy.problem;

public abstract class Duck {

    void quack() {
        System.out.println("Quack");
    }

    void fly() {
        System.out.println("Flying");
    }

    void swim() {
        System.out.println("Swimming");
    }

    abstract void display();
}
