package com.narendra.strategy.problem;

/*
We want to extract the frequently changing behaviours from Duck class and encapsulate it in a different class.
 */
public class DuckTest {
    public static void main(String[] args) {
        Duck mallar = new MallarDuck();

        mallar.fly();
        mallar.quack();
        mallar.swim();
        mallar.display();

        Duck rubber = new MallarDuck();
        //This fly method was introduced as a change in Duck class.
        //Since Rubber duck extends Duck it automatically got flying capability. But we don't want this to happen.
        rubber.fly();
        rubber.quack();
        rubber.swim();
        rubber.display();
    }
}
