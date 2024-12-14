package com.narendra.state;

import java.util.Random;

public class StateTest {

    public static void main(String[] args) {
        GumBallMachine gumBallMachine = new GumBallMachine(5);

        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();

        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();

        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();

        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
    }
}

class GumBallMachine {
    private SoldState soldState;
    private SoldOutState soldOutState;
    private NoQuarterState noQuarterState;
    private HasQuarterState hasQuarterState;
    private WinnerState winnerState;
    private State state;
    private int count = 0;

    GumBallMachine(int count) {
        this.count = count;
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        winnerState = new WinnerState(this);

        if(count > 0) {
            state = noQuarterState;
        } else {
            state = soldState;
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public SoldState getSoldState() {
        return soldState;
    }

    public void setSoldState(SoldState soldState) {
        this.soldState = soldState;
    }

    public SoldOutState getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(SoldOutState soldOutState) {
        this.soldOutState = soldOutState;
    }

    public NoQuarterState getNoQuarterState() {
        return noQuarterState;
    }

    public void setNoQuarterState(NoQuarterState noQuarterState) {
        this.noQuarterState = noQuarterState;
    }

    public HasQuarterState getHasQuarterState() {
        return hasQuarterState;
    }

    public void setHasQuarterState(HasQuarterState hasQuarterState) {
        this.hasQuarterState = hasQuarterState;
    }

    public WinnerState getWinnerState() {
        return winnerState;
    }

    public void setWinnerState(WinnerState winnerState) {
        this.winnerState = winnerState;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot");

        if(count > 0) {
            count --;
        }
    }

    void insertQuarter() {
        state.insertQuarter();
    }

    void ejectQuarter() {
        state.ejectQuarter();
    }

    void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
}

interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

class SoldState implements State {
    private GumBallMachine gumBallMachine;
    SoldState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait we are already giving you a gumball.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't give you another gumball");
    }

    @Override
    public void dispense() {
        gumBallMachine.releaseBall();

        if(gumBallMachine.getCount() > 0) {
            gumBallMachine.setState(gumBallMachine.getNoQuarterState());
        } else {
            System.out.println("All balls were sold out");
            gumBallMachine.setState(gumBallMachine.getSoldOutState());
        }
    }
}

class NoQuarterState implements State {
    private GumBallMachine gumBallMachine;
    NoQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        gumBallMachine.setState(gumBallMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there is no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }
}

class HasQuarterState implements State {
    private final Random randomWinner = new Random(System.currentTimeMillis());
    private GumBallMachine gumBallMachine;
    HasQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Giving back your quarter");
        gumBallMachine.setState(gumBallMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned crank");
        int winner = randomWinner.nextInt(10);

        if((winner == 0) && (gumBallMachine.getCount() > 1)) {
            gumBallMachine.setState(gumBallMachine.getWinnerState());
        } else {
            gumBallMachine.setState(gumBallMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed, you need to turn crank first");
    }
}

class SoldOutState implements State {
    private GumBallMachine gumBallMachine;
    SoldOutState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("The machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("There are no gum balls");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}

class WinnerState implements State {
    private GumBallMachine gumBallMachine;
    WinnerState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we are already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't give you another gumball");
    }

    @Override
    public void dispense() {
        gumBallMachine.releaseBall();

        if(gumBallMachine.getCount() > 0) {
            System.out.println("You are a winner, you will get second gumball for free");
            gumBallMachine.releaseBall();
        }

        if(gumBallMachine.getCount() > 0) {
            gumBallMachine.setState(gumBallMachine.getNoQuarterState());
        } else {
            System.out.println("Sold out all gumballs");
            gumBallMachine.setState(gumBallMachine.getSoldOutState());
        }
    }
}