package ru.job4j.concat;

public class ConcatTest {
    public static void main(String[] args) {
        long startT = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            long startTime = System.currentTimeMillis();
            String str = "Job4j";
            for (int index = 0; index < 9999; index++) {
                str = str + index;
            }
            System.out.println("\t\tМиллисекунд: " + (System.currentTimeMillis() - startTime));
        }
        System.out.println("\tМиллисекунд: " + (System.currentTimeMillis() - startT));
    }
}
