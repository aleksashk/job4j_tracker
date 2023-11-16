package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import java.util.Arrays;

public class StartUITest {

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Store store = new MemTracker();
        UserAction[] actions = {new ExitAction(output)};
        new StartUI(output).init(in, store, Arrays.asList(actions));
        Assert.assertEquals(output.toString(),
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        );
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item one = store.add(new Item("test1"));
        String replacedItem = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replacedItem, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output), new ExitAction(output)
        };
        new StartUI(output).init(in, store, Arrays.asList(actions));
        String ln = System.lineSeparator();
        Assert.assertEquals(output.toString(),
                "Menu:" + ln
                        + "0. Replace item" + ln
                        + "1. Exit Program" + ln
                        + "Replace item" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Replace item" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenFindAllItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item item = new Item("test1");
        Item item1 = new Item("test2");
        Item item2 = new Item("test3");
        store.add(item);
        store.add(item1);
        store.add(item2);
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(output), new ExitAction(output)
        };
        new StartUI(output).init(in, store, Arrays.asList(actions));
        String ln = System.lineSeparator();
        Assert.assertEquals(output.toString(),
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "Show all items" + ln
                        + item + ln
                        + item1 + ln
                        + item2 + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenFindByNameItemsTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item item = new Item("test1");
        Item item1 = new Item("test1");
        Item item2 = new Item("test3");
        Item item3 = new Item("test2");
        store.add(item);
        store.add(item1);
        store.add(item2);
        store.add(item3);
        Input in = new StubInput(
                new String[]{"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output), new ExitAction(output)
        };
        new StartUI(output).init(in, store, Arrays.asList(actions));
        String ln = System.lineSeparator();
        Assert.assertEquals(output.toString(),
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "Find items by name" + ln
                        + item + ln
                        + item1 + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln);
    }

    @Test
    public void whenFindByIdItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item item = new Item("Test1");
        Item item1 = new Item("Test2");
        store.add(item);
        store.add(item1);
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output), new ExitAction(output)
        };
        String ln = System.lineSeparator();
        new StartUI(output).init(in, store, Arrays.asList(actions));
        Assert.assertEquals(output.toString(),
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "Find item by id" + ln
                        + item + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln);
    }
}