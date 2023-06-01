package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Train is moving by railway");
    }

    @Override
    public void infoMessage() {
        System.out.println("This is ATSF E1 A/B-unit");
    }
}
