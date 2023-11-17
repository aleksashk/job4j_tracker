package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println(name());
        int id = input.askInt("Enter id: ");

        if (store.findById(id) == null) {
            out.println("Ошибка: элемент с таким id не найден.");
            return false;
        }

        store.delete(id);

        if (store.findById(id) == null) {
            out.println("Заявка удалена успешно.");
            return true;
        } else {
            out.println("Ошибка при удалении заявки.");
            return false;
        }
    }
}
