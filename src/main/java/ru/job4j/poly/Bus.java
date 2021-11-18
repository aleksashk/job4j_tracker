package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void drive() {
        System.out.println("Bus is going");
    }

    @Override
    public void passengers(int numberOfPassengers) {
        System.out.println("There are " + numberOfPassengers + " passengers in the bus");
    }

    @Override
    public double refuel(int volumeOfFuel) {
        double price = 2.01;
        return volumeOfFuel * price;
    }

    @Override
    public void move() {
        System.out.println("bus rides on road");
    }
}
