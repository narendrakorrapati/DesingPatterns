package com.narendra.facade;

public class FacadeTest {

    public static void main(String[] args) {

        Client client = new Client(new MovieFacadeImpl(new Popcorn(), new MovieScreen(), new Light()));

        client.watchMovie();
        client.stopMovie();
    }
}

class Client {

    private MovieFacade movieFacade;
    Client(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    void watchMovie() {
        movieFacade.watchMovie();
    }

    void stopMovie() {
        movieFacade.stopMovie();
    }
}

interface MovieFacade {
    void watchMovie();
    void stopMovie();
}

class MovieFacadeImpl implements MovieFacade {

    private Popcorn popcorn;
    private MovieScreen movieScreen;
    private Light light;
    MovieFacadeImpl(Popcorn popcorn, MovieScreen movieScreen, Light light) {
        this.light = light;
        this.movieScreen = movieScreen;
        this.popcorn = popcorn;
    }
    @Override
    public void watchMovie() {
        popcorn.ready();
        light.dim();
        movieScreen.on();
    }

    @Override
    public void stopMovie() {
        movieScreen.off();
        light.on();
    }

}

class Popcorn {
    void ready() {
        System.out.println("popcorn ready");
    }
}

class MovieScreen {

    void on() {
        System.out.println("Movie screen is on");
    }

    void off() {
        System.out.println("Movie screen is off");
    }
}

class Light {

    void dim() {
        System.out.println("Lights dim");
    }

    void on() {
        System.out.println("Lights on");
    }
}
