package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapLambdaUsage {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");

        map.forEach((k, v) -> System.out.println("Key: " + k + ", value: " + v));

        BiFunction<Integer, String, String> function = (k, v) -> v + "_" + k;
        map.replaceAll(function);

        map.forEach((k, v) -> System.out.println("Key: " + k + ", value: " + v));
    }
}
