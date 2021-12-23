package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asdf");
        list.add("fdsa");
        list.add("sdfaasd");
        list.add("");
        list.add("-");
        list.add("tewerwerwewtghf");
        list.add("qwe");

        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();
        Arrays.sort(atts, comparator);

        Comparator<String> cmpSize = (left, right) -> left.length() - right.length();
        list.sort(cmpSize);

        /**
         * Компаратор для строк через лямбда. Строки сравниваются через метод compareTo.
         * на параметре строке left вызываем метод compareTo() и передаём туда строку right;
         * @param left - левая строка для сравнения
         * @param right - правая строка для сравнения
         */
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);

        /**
         * Компаратор для строк через лямбда. Компаратор сортирует строки по убыванию длины.
         * @param left - левая строка для сравнения
         * @param right - правая строка для сравнения
         */
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
    }
}