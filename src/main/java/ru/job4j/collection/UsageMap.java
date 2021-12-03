package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("asdf@mail.ru", "Ivanov Ivan Ivanovich");
        map.put("fdsa@mail.ru", "Petrov Petr Petrovich");
        map.put("sdfa@mail.ru", "Vladimirov Vladimir Vladimirovich");
        for (String email : map.keySet()) {
            String person = map.get(email);
            System.out.println(email + " -> " + person);
        }
        System.out.println("---------------------------");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
