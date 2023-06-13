package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("One", "Boom", "Eight", "Seven", "Eleven", "Five", "Zero", "Two", "Three");
        boolean result = strings.stream()
                .noneMatch("Grass"::contains);
        System.out.println(result);

        List<String> strings1 = Arrays.asList("One", "Boom", "Eight", "Seven", "Eleven", "Five", "Zero", "Two", "Three");
        boolean result1 = strings1.stream()
                .anyMatch(e -> e.endsWith("m"));
        System.out.println(result1);

        List<String> strings2 = Arrays.asList("One", "OBoom", "OEight", "OSeven", "OEleven", "OFive", "OZero", "OTwo", "OThree");
        boolean result2 = strings2.stream()
                .allMatch(e -> e.startsWith("O"));
        System.out.println(result2);
    }
}
