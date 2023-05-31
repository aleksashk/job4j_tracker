package ru.job4j.concat;

public class ConcatTest {
    public static void main(String[] args) {
        long startT = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            long startTime = System.currentTimeMillis();
            StringBuilder str = new StringBuilder("Job4j");
            for (int index = 0; index < 9999; index++) {
                str.append(index);
            }
            System.out.println("\t\tМиллисекунд: " + (System.currentTimeMillis() - startTime));
        }
        System.out.println("\tМиллисекунд: " + (System.currentTimeMillis() - startT));
    }
}
