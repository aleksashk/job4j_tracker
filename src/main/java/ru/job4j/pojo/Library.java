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
        library[0] = book3;
        library[3] = cleanCode;
        for (Book value : library) {
            System.out.println(value);
        }
        for (Book book : library) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book);
            }
        }
    }
}
