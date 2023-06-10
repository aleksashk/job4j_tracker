package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Supplier<String> simpleSup = () -> "New String For Interface";
        System.out.println(simpleSup.get());

        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        BiConsumer<Integer, String> biCon = (i, str) -> map.put(i, str);

        int counter = 1;
        for (String s : list) {
            biCon.accept(counter++, s);
        }

        System.out.println(map);

        BiPredicate<Integer, String> biPred = (i, str) -> i % 2 == 0 || str.length() == 4;

        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        System.out.println(sup.get());

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = (s) -> s.toUpperCase();
        for (String s : map.values()) {
            con.accept(func.apply(s));
        }
    }
}
