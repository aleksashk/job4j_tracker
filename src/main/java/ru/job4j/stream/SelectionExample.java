package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six");
        List<String> result = strings.stream()
                .skip(2)
                .toList();
        System.out.println(result);
    }
}
