package com.narendra.singleton;

public class SingletonEnum {

    public static void main(String[] args) {
        Singleton2 s1 = Singleton2.INSTANCE;
        Singleton2 s2 = Singleton2.INSTANCE;

        System.out.println(s1 == s2);
    }
}

enum Singleton2 {
    INSTANCE;

    void doSomething() {
        System.out.println("Enum singleton");
    }
}
