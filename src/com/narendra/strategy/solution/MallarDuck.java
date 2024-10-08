package com.narendra.strategy.solution;

import com.narendra.strategy.solution.Duck;

public class MallarDuck extends Duck {

    public MallarDuck() {
        quackBehaviour = new Quack();
        flyBehaviour = new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("Looks like Mallar Duck");
    }
}
