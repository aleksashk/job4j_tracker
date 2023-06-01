package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("The bus is moving by road");
    }

    @Override
    public void infoMessage() {
        System.out.println("This is SCANIA");
    }
}
