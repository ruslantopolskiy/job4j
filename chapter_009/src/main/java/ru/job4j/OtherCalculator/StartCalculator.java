package ru.job4j.OtherCalculator;

public class StartCalculator {
    private final Input input;
    private final MenuCalculator menuCalculator;

    public StartCalculator(Input input, MenuCalculator menuCalculator) {
        this.input = input;
        this.menuCalculator = menuCalculator;
    }

    public void init() {
        do{
        menuCalculator.mapInit();
        menuCalculator.show();
        menuCalculator.select(input.askString("Выберите действие: "));
    }while (!"y".equalsIgnoreCase(input.askString("Для выхода из приложения Y(y)")));

    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        MenuCalculator menuCalculator = new MenuCalculator(input);
        new StartCalculator(input, menuCalculator).init();
    }
}
