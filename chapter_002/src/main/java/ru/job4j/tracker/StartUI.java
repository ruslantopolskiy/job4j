package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;


public class StartUI {

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menuTracker.fillActions();
        for (int index = 0; index < menuTracker.getSizeActions(); index++) {
            range.add(index);
        }

        do {
            menuTracker.show();
            menuTracker.select(input.ask("select: " + range, menuTracker.getMassives()));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

}
