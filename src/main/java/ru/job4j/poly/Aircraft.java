package ru.job4j.poly;

public class Aircraft implements Vehicle {
    @Override
    public void move() {
        System.out.println("aircraft flies");
    }
}
