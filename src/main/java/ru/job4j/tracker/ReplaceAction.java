package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Item deleted";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(name());
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
            return true;
        } else {
            System.out.println("Ошибка удаления заявки.");
            return false;
        }
    }
}
