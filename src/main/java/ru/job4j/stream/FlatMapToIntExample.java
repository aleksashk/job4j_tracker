package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapToIntExample {
    public static void main(String[] args) {
        int[] array1 = {2, 3, 4};
        int[] array2 = {5, 6, 7};
        int[] array3 = {8, 9, 40};

        List<Integer> list = Stream.of(array1, array2, array3)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
