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
        List<String> result2 = strings.stream()
                .limit(2)
                .toList();
        System.out.println(result2);
        List<String> result3 = strings.stream()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println(result3);
        String result4 = strings.stream()
                .skip(2)
                .findFirst()
                .orElse("Default value");
        System.out.println(result4);
        String result5 = strings.stream()
                .skip(strings.size() - 1)
                .findFirst()
                .orElse("Default value");
        System.out.println(result5);
    }
}
