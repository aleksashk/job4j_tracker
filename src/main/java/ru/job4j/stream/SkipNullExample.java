package ru.job4j.stream;

import java.util.stream.Stream;

public class SkipNullExample {
    public static void main(String[] args) {
        Stream.of("Value", null, "Bob", "Tree", null)
                .flatMap(Stream::ofNullable)
                .map(v -> "Result: " + v)
                .forEach(System.out::println);
    }
}
