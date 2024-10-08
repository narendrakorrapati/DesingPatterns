package com.narendra.strategy.solution;

public class MuteQuack implements QuackBehaviour{


    @Override
    public void quack() {
        System.out.println("Can't quack");
    }
}
