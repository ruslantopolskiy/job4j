package ru.job4j.InteractCalculator;

public interface UserAction {
    int key();

    String info();

    void execute(Input input);

}
