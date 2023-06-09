package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < evenElements.size() / 2; i++) {
            Character ch = evenElements.pollFirst();
            sb.append(ch);
            evenElements.add(ch);
            evenElements.add(evenElements.pollFirst());
        }
        return sb.toString();
    }

    private String getDescendingElements() {
        StringBuilder sb = new StringBuilder();
        for (int i = descendingElements.size(); i > 0; i--) {
            Character ch = descendingElements.pollLast();
            sb.append(ch);
            descendingElements.addFirst(ch);
        }
        return sb.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
