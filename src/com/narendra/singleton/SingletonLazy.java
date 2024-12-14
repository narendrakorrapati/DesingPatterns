package com.narendra.singleton;

public class SingletonLazy {

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}

class Singleton{
    private static volatile Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
