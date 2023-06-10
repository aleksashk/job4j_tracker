package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

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

        Map<Integer, String> map1 = new HashMap<>();
        map.put(1, "name");

        BiFunction<Integer, String, String> function1 = (key, value) -> value + "_" + key;
        String result = map.computeIfPresent(1, function1);
        System.out.println("Current value: " + result);
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        Map<String, Integer> map2 = new HashMap<>();
        Function<String, Integer> function2 = String::length;
        map2.computeIfAbsent("Aleksandr", function2);
        map2.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
    }
}
