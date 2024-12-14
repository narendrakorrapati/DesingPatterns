package com.narendra.adaptor;

public class AdaptorTest {

    public static void main(String[] args) {
        client client = new client();
        client.doSomething();
    }
}

class client {
    Adaptor adaptor = new AdaptorImpl(new Adapted());

    void doSomething() {
        adaptor.request();
    }
}

interface Adaptor {
    void request();
}

class AdaptorImpl implements Adaptor {

    private Adapted adapted;
    AdaptorImpl(Adapted adapted) {
        this.adapted = adapted;
    }

    @Override
    public void request() {
        adapted.someRequest();
    }
}

class Adapted {

    void someRequest() {
        System.out.println("called");
    }
}
