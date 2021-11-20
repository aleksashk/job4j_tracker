package ru.job4j.ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void calcFactWhenParamMinus5() {
        Fact fact = new Fact();
        int number = -5;
        fact.calc(number);
    }
}