package ru.job4j.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class TakeWhileExample {
    public static void main(String[] args) {
        Stream.of(-25, 100, -8, 0, 1, 2, 3, 4)
                .sorted(Comparator.naturalOrder())
                .takeWhile(value -> value < 3)
                .map(value -> "Result: " + value)
                .forEach(System.out::println);
    }
}
