package com.narendra.command;

import java.util.ArrayDeque;

public class RemoteControlWithUndo {

    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        Command fanOnCommand = new FanOnCommand(fan);
        Command fanOffCommand = new FanOffCommand(fan);
        Command fanIncreaseSpeedCommand = new FanIncreaseSpeedCommand(fan);
        Command fanDecreaseSpeedCommand = new FanDecreaseSpeedCommand(fan);

        Invoker invoker = new Invoker();
        Command[] commands = new Command[]{lightOnCommand, lightOffCommand, fanOnCommand, fanOffCommand, fanIncreaseSpeedCommand, fanDecreaseSpeedCommand};
        invoker.setCommands(commands);

        invoker.pressButton(0);
        invoker.pressButton(1);
        invoker.pressUndo();
        invoker.pressButton(2);
        invoker.pressButton(3);
        invoker.pressButton(4);
        invoker.pressButton(4);
        invoker.pressUndo();
        invoker.pressUndo();
        invoker.pressUndo();
    }

}

class Invoker {
    Command[] commands = new Command[6];
    ArrayDeque<Command> stack = new ArrayDeque<>();
    void setCommands(Command[] commands) {
        this.commands = commands;
    }

    void pressButton(int slot) {
        commands[slot].execute();
        stack.push(commands[slot]);
    }

    void pressUndo() {
        if(stack.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }

        stack.pop().undo();
    }
}

interface Command{
    void execute();
    void undo();
}

class Light{

    void on() {
        System.out.println("Light is turned on");
    }
    void off() {
        System.out.println("Light is turned off");
    }
}

class Fan{
    int speed = 3;
    void on() {
        System.out.println("Fan is turned on");
    }
    void off() {
        System.out.println("Fan is turned off");
    }

    void increaseSpeed() {
        speed += 1;
        System.out.println("Fan speed is set to " + speed);
    }
    void decreaseSpeed() {
        speed -= 1;
        System.out.println("Fan speed is set to " + speed);
    }

}

class LightOnCommand implements Command {

    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class LightOffCommand implements Command {

    private Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}


class FanOnCommand implements Command {

    private Fan fan;

    FanOnCommand(Fan fan) {
        this.fan = fan;
    }
    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}

class FanOffCommand implements Command {

    private Fan fan;

    FanOffCommand(Fan fan) {
        this.fan = fan;
    }
    @Override
    public void execute() {
        fan.off();
    }

    @Override
    public void undo() {
        fan.on();
    }
}

class FanIncreaseSpeedCommand implements Command {

    private Fan fan;

    FanIncreaseSpeedCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.increaseSpeed();
    }

    @Override
    public void undo() {
        fan.decreaseSpeed();
    }
}

class FanDecreaseSpeedCommand implements Command {

    private Fan fan;

    FanDecreaseSpeedCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.decreaseSpeed();
    }

    @Override
    public void undo() {
        fan.increaseSpeed();
    }
}
