package ru.job4j.cast;

public class Aircraft implements Vehicle {
    @Override
    public void move() {
        System.out.println("Aircraft is flying...");
    }

    @Override
    public void infoMessage() {
        System.out.println("This is Boing 777");
    }
}
