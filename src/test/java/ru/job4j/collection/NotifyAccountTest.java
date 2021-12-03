package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expected = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        HashSet<Account> actual = NotifyAccount.sent(accounts);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeDuplicates() {
        List<Account> list = Arrays.asList(
                new Account("123456789", "Ivan Ivanov", "0g1h1j2k7i8uu"),
                new Account("987654321", "Petr Petrov", "122h1j2g9i877"),
                new Account("123456789", "Ivan Ivanov", "0g1h1j2k7i8uu")
        );
        HashSet<Account> actual = NotifyAccount.sent(list);
        HashSet<Account> expected = new HashSet<>(
                Arrays.asList(
                        new Account("987654321", "Petr Petrov", "122h1j2g9i877"),
                        new Account("123456789", "Ivan Ivanov", "0g1h1j2k7i8uu")
                )
        );
        Assert.assertEquals(expected, actual);
    }
}