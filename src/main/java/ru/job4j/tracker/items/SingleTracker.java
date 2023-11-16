package ru.job4j.tracker.items;

import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker instance = null;
    private Store store = new MemTracker();

    private SingleTracker() {
    }

    public SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return store.add(item);
    }

    public Item findById(int id) {
        return store.findById(id);
    }

    public List<Item> findAll() {
        return store.findAll();
    }

    public boolean replace(int id, Item item) {
        return store.replace(id, item);
    }

    List<Item> findByName(String key) {
        return store.findByName(key);
    }

    public void delete(int id) {
        store.delete(id);
    }
}
