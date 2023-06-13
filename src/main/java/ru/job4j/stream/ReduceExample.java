package ru.job4j.stream;

import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 55);
        Optional<Integer> sum = nums.stream()
                .reduce((a, b) -> a + b);
        System.out.println(sum.get());
        List<String> strings = List.of("1", "2", "3", "4", "55");
        Optional<String> sumStrings = strings.stream()
                .reduce((a, b) -> a + ", " + b);
        System.out.println(sumStrings.get());
    }
}
