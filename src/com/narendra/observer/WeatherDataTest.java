package com.narendra.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataTest {

    public static void main(String[] args) {
        WeatherDataObserver observer = new WeatherDataObserver();

        observer.subscribe(new DisplayWeahterDataSubscriber(observer, "Guntur"));
        observer.subscribe(new DisplayWeahterDataSubscriber(observer, "Vijayawada"));
        observer.subscribe(new DisplayWeahterDataSubscriber(observer, "Hyderabad"));

        observer.setData(99, 10);
        observer.setData(100, 101);
    }
}

interface Observer {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
}

interface Subscriber {
    void update();
}

class WeatherDataObserver implements Observer {
    List<Subscriber> subscribers = new ArrayList<>();

    int temperature = 100;
    int wind = 23;

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    void setData(int temperature, int wind) {
        this.temperature = temperature;
        this.wind = wind;
        updateSubscribers();
    }

    private void updateSubscribers() {

        for(Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
}

class DisplayWeahterDataSubscriber implements Subscriber{

    private WeatherDataObserver weatherDataObserver;
    private String name;

    DisplayWeahterDataSubscriber(WeatherDataObserver weatherDataObserver, String name) {
        this.weatherDataObserver = weatherDataObserver;
        this.name = name;
    }

    @Override
    public void update() {
        displayData();
    }

    void displayData() {
        System.out.println(name + "=> temperature:" + weatherDataObserver.temperature + ", Wind: " + weatherDataObserver.wind);
    }
}
