package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Supplier<String> simpleSup = () -> "New String For Interface";
        Consumer<String> simpleConsumer = (s) -> System.out.println(s);
        simpleConsumer.accept(simpleSup.get());
        System.out.println(simpleSup.get());
        BiConsumer<String, String> simpleBiConsumer = (s1, s2) -> System.out.println(s1 + s2);
        simpleBiConsumer.accept(simpleSup.get(), " and Second String");

        List<String> simpleList = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> simpleSupHash = () -> new HashSet<>(simpleList);
        Set<String> strings = simpleSupHash.get();
        for (String string : strings) {
            System.out.println(string);
        }
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        BiConsumer<Integer, String> biCon = (i, str) -> map.put(i, str);
        Supplier<Set<String>> simpleSupplier = () -> new HashSet<>(list);
        BiConsumer<Integer, String> consumer = (s1, s2) -> System.out.println(s1 + s2);
        Set<String> simpleString = simpleSupplier.get();
        int g = 1;
        for (String string : strings) {
            consumer.accept(g++, " is " + string);
        }

        Predicate<String> simplePredicate = s -> s.isEmpty();
        System.out.println("The String is empty: " + simplePredicate.test(""));
        System.out.println("The String is empty: " + simplePredicate.test("test"));

        BiPredicate<String, Integer> condition = (s, i) -> s.contains(i.toString());
        System.out.println("The String is contains substring: " + condition.test("String123", 123));
        System.out.println("The String is contains substring: " + condition.test("String13", 12));

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
