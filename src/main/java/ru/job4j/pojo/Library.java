package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 100);
        Book book1 = new Book("Book1", 100);
        Book book2 = new Book("Book2", 500);
        Book book3 = new Book("Book3", 1600);

        Book[] library = {cleanCode, book1, book2, book3};

        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i]);
        }

        library = new Book[]{book3, book1, book2, cleanCode};

        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i]);
        }
    }
}
