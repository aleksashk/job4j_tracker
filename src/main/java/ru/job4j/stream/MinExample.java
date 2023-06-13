package ru.job4j.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 55, 32, -8, 0, 576, -57);
        Optional<Integer> min = list.stream()
                .min(Comparator.naturalOrder());
        System.out.println(min.get());
    }
}
