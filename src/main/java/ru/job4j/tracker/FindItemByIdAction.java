package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Item found by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
            return true;
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
            return false;
        }
    }
}
