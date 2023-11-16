package ru.job4j.stream;

import java.util.stream.Stream;

public class TakeWhileExample {
    public static void main(String[] args) {
        Stream.of(-7, -25, 100, -8, 0, 1, 2, 3, 4)
                .dropWhile(value -> value < 3)
                .map(value -> "Result: " + value)
                .forEach(System.out::println);
    }
}
