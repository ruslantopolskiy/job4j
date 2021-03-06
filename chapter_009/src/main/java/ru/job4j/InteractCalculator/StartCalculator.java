package ru.job4j.InteractCalculator;

import ru.job4j.calculator.Calculator;

import java.util.function.Function;

public class StartCalculator {
    private final Input input;
    private final MenuCalculator menuCalculator;
    private final Calculator calculator;

    public StartCalculator(Input input, MenuCalculator menuCalculator, Calculator calculator) {
        this.input = input;
        this.menuCalculator = menuCalculator;
        this.calculator = calculator;
    }

    public void init() {
        do {
            menuCalculator.show();
            menuCalculator.select((int)input.ask("Выберите действие: "));
        } while (!"y".equalsIgnoreCase(input.askExit("Exit(y/n)?")));
    }



    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Input input = new ConsoleInput(calculator);
        MenuCalculator menuCalculator = new MenuCalculator(calculator, input);
        menuCalculator.inizialse();
        new StartCalculator(input,menuCalculator,calculator).init();
    }
}
