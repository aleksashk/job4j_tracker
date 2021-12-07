package ru.job4j.banc;

import java.util.Objects;

/**
 * Класс описывает структуру банковского счёта.
 * @author ALEKSANDR PHILIMONOV
 * @version 1.0
 */

public class Account {

    /**
     * У счёта есть два поля {@code requisite} и {@code balance}.
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор принимает два параметра:
     * @param requisite - реквизиты счета в виде строки
     * @param balance - количество денег в виде значения double.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает значение поля {@code requisite}.
     * @return возвращает реквизиты счета клиента банка в виде строки
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод устанавливает значение поля {@code requisite}.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает значение поля {@code balance}.
     * @return возвращает баланс счета клиента банка в виде значения double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод устанавливает значение поля {@code balance}.
     */
    public void setBalance(double balance) {
        this.balance = balance;
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода {@code hashCode()}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}