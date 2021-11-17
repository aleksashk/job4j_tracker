package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            while ((matches < 1 || matches > 3) && matches <= count) {
                System.out.println("Вы взяли неправильное количество спичек. Попробуйте ещё раз.");
                matches = Integer.parseInt(input.nextLine());
            }
            turn = !turn;
            count -= matches;
            System.out.println("На столе осталось " + count + " спичек");
        }
        String msg = turn ? "Выиграл второй игрок" : "Выиграл первый игрок";
        System.out.println(msg);
    }
}