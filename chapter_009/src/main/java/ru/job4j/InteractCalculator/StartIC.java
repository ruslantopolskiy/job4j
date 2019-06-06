package ru.job4j.InteractCalculator;

public class StartIC {
    private final Input input;

    public StartIC(Input input) {
        this.input = input;
    }


    public static void main(String[] args) {

       new StartIC(new ConsoleInput()).init();
    }

    public void init() {

        do {
        } while ("y".equalsIgnoreCase(input.askExit("Exit(y)")));

    }


}
