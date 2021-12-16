package ru.job4j.collection;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] arrayO1 = o1.split("/");
        String[] arrayO2 = o2.split("/");
        int rsl = arrayO1[0].compareTo(arrayO2[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}