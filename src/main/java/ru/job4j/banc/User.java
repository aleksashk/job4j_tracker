package ru.job4j.banc;

import java.util.Objects;

/**
 * Класс описывает структуру клиента банка.
 * @author ALEKSANDR PHILIMONOV
 * @version 1.0
 */
public class User {

    /**
     * У клиента банка есть два поля
     * passport - паспортные данные (String) клиента банка
     * username - ФИО клиента банка
     */
    private String passport;
    private String username;

    /**
     * Конструктор принимает два параметра:
     * @param passport - паспортные данные (String) клиента банка
     * @param username - ФИО клиента банка
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает значение поля {@code passport}.
     * @return возвращает паспортные данные клиента банка в виде строки.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод устанавливает значение поля {@code passport} клиента банка.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает значение поля {@code username} клиента банка.
     * @return возвращает ФИО клиента банка в виде строки.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод устанавливает значение поля {@code username} клиента банка.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода {@code equals()}.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода {@code hashCode()}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}