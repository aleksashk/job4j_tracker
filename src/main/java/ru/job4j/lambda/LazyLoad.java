package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LazyLoad {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);

        names = new String[]{"Ivan", "Petr"};
        Arrays.sort(names, lengthCmp);
    }
}
