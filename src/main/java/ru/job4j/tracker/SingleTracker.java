package ru.job4j.tracker;

public final class SingleTracker {
    private static Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public Tracker getInstance() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}
