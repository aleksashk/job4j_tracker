package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.sort.ItemAscByName;
import ru.job4j.tracker.sort.ItemDescByName;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void whenSortNameAsc() {
        List<Item> list = Arrays.asList(
                new Item(123, "Create"),
                new Item(345, "Update"),
                new Item(678, "Write Logs"),
                new Item(910, "Fix problems"));
        Collections.sort(list, new ItemAscByName());

        List<Item> expected = Arrays.asList(
                new Item(123, "Create"),
                new Item(910, "Fix problems"),
                new Item(345, "Update"),
                new Item(678, "Write Logs"));

        assertEquals(expected, list);
    }

    @Test
    public void whenSortNameDesc() {
        List<Item> list = Arrays.asList(
                new Item(123, "Create"),
                new Item(345, "Update"),
                new Item(678, "Write Logs"),
                new Item(910, "Fix problems")
        );

        Collections.sort(list, new ItemDescByName());

        List<Item> expected = Arrays.asList(
                new Item(678, "Write Logs"),
                new Item(345, "Update"),
                new Item(910, "Fix problems"),
                new Item(123, "Create")
        );

        assertEquals(expected, list);
    }

}