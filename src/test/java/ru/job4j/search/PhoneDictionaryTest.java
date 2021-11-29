package ru.job4j.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        String expected = persons.get(0).getSurname();
        String actual = "Arsentev";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenDontFind() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("123");
        int expected = persons.size();
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }
}