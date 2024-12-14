package com.narendra.templatemethod;

public class TemplateMethodTest {

    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        CaffeineBeverage coffee = new Coffee();

        tea.prepareRecipe();
        coffee.prepareRecipe();
    }

}

abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();
    abstract void addCondiments();

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    void boilWater() {
        System.out.println("Boiling water");
    }
}

class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Dipping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and Milk");
    }
}

class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
