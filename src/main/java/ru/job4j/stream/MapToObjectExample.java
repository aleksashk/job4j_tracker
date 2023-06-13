package ru.job4j.stream;

import java.util.List;
import java.util.stream.IntStream;

public class MapToObjectExample {
    public static void main(String[] args) {
        List<String> list = IntStream.range(1, 500)
                .mapToObj(String::valueOf)
                .toList();
        System.out.println(list);
    }
}
