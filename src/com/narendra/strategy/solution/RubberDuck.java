package com.narendra.strategy.solution;

import com.narendra.strategy.solution.Duck;

public class RubberDuck extends Duck {

    public RubberDuck() {
        quackBehaviour = new Squeak();
        flyBehaviour = new FlyNoWay();
    }
    @Override
    void display() {
        System.out.println("Looks like Rubber Duck");
    }
}
