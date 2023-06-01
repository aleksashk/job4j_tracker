package ru.job4j.cast;

public class Starter {
    public static void main(String[] args) {
        Vehicle boing = new Aircraft();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] vehicles = {boing, train, bus};

        for (Vehicle v : vehicles) {
            v.infoMessage();
            v.move();
        }
    }
}
