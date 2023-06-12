package ru.job4j.stream;

import java.util.List;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    +
                    "name='" + name + '\''
                    +
                    ", spent=" + spent
                    +
                    '}';
        }

        public static void main(String[] args) {
            List<Task> tasks = List.of(
                    new Task("Bug #1", 100),
                    new Task("Bug #2", 100),
                    new Task("Bu #3", 100),
                    new Task("Bug #4", 100)
            );
            List<Task> bugs = tasks.stream().filter(task -> task.name.contains("Bug"))
                    .toList();
            bugs.forEach(System.out::println);

            List<String> bugsOnlyName = tasks.stream().map(task -> task.name).toList();
            bugsOnlyName.forEach(System.out::println);
        }
    }
}