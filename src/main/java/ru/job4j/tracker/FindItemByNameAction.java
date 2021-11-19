package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {
    private final Output out;

    public FindItemByNameAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Item found by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
            return true;
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
            return false;
        }
    }
}
