package ru.job4j.poly;

public class MainApp {
    public static void main(String[] args) {
        Vehicle aircraft1 = new Aircraft();
        Vehicle bus1 = new Bus();
        Vehicle aircraft2 = new Aircraft();
        Vehicle bus2 = new Bus();
        Vehicle aircraft3 = new Aircraft();
        Vehicle train = new Train();

        Vehicle[] vehicles = {aircraft1, bus1, aircraft2, bus2, aircraft3, train};
        for (Vehicle item : vehicles) {
            item.move();
        }
    }
}
