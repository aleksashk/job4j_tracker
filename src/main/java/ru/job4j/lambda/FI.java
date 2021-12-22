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

        //на параметре строке left вызываем метод compareTo() и передаём туда строку right;
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);

        //от размера строки right вычитаем размер строки left и таким образом организовываем
        //сортировку строк по убыванию
        Comparator<String> cmpDescSize = (left, right) -> right.length() - left.length();
    }
}