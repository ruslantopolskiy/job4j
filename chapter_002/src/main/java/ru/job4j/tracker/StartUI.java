package ru.job4j.tracker;

import java.util.List;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

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

        int[] ranges = new int[range.size()];
        for (int index = 0; index < range.size(); index++) {
            ranges[index] = range.get(index);
        }

        do {
            menuTracker.show();
            menuTracker.select(input.ask("select: " + range, ranges));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }

}
