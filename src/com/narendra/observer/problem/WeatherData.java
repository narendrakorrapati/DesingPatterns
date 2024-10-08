package com.narendra.observer.problem;

public class WeatherData {

    public static void main(String[] args) {
        try {
            System.out.println("In try block");
            int result = 10 / 0;  // This will throw an ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("In catch block");
            throw new RuntimeException("New exception in catch block");  // Another exception is thrown
        } finally {
            System.out.println("In finally block");
        }
    }
}
