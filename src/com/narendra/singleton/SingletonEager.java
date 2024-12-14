package com.narendra.singleton;

public class SingletonEager {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}

class Singleton1{
    private static final Singleton1 singleton = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return singleton;
    }
}
