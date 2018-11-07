package ru.job4j.tracker;

public interface Input {
    String ask(String questions);

    int ask(String questions, int[] ranges);
}

