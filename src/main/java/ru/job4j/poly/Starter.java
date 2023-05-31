package ru.job4j.poly;

public class Starter {
    public static void main(String[] args) {
        MemStore store = new MemStore();
        Service service = new Service(store);
        service.add();
    }
}
