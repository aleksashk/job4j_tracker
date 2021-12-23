package ru.job4j.lambda;

import java.util.Arrays;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        System.out.println(Arrays.stream(number).sum());
    }
}