package ru.job4j.stream;

import java.util.Arrays;
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

        List<Integer> nums1 = List.of(1, 2, 3, 4, 55);
        int sum1 = nums.stream()
                .reduce(2, (a, b) -> a + b);
        System.out.println(sum1);

        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum3 = people.stream()
                .reduce(
                        0,
                        (a, b) -> {
                            if (b.getAge() > 25) {
                                return a + b.getAge();
                            } else {
                                return a;
                            }
                        },
                        (a, b) -> a + b
                );
        System.out.println(sum3);
    }
}
