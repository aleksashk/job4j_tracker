package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MapToIntExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("11", "0", "1", "2", "3", "4", "5");
        strings.stream()
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );

        int sum = people.stream()
                .filter(e -> e.getAge() > 25)
                .mapToInt(Person::getAge)
                .peek(System.out::println)
                .sum();

        System.out.println("SUMMA: " + sum);
    }
}
