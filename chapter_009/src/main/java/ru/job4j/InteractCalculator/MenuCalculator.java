package ru.job4j.InteractCalculator;

import ru.job4j.calculator.Calculator;

import java.util.ArrayList;
import java.util.List;

public class MenuCalculator {
    private final Calculator calculator;
    private final Input input;

    public MenuCalculator(Calculator calculator, Input input) {
        this.calculator = calculator;
        this.input = input;
    }

    List<UserAction> list = new ArrayList<>();

    public void inizialse() {
        list.add(0, new add(0, "Суммирование"));
        list.add(1, new subtract(1, "Вычитание"));
        list.add(2, new multiple(2, "Умножение"));
        list.add(3, new div(3, "Деление"));
    }

    public void show() {
        for (UserAction userAction : list) {
            if (userAction != null)
                System.out.println(userAction.info());
        }
    }

    public void select (int key){
        list.get(key).execute(this.input);
    }


    public abstract class BaseAction implements UserAction {
        private int key;
        private String name;

        public BaseAction(int key, String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key, this.name);
        }
    }

    public class div extends BaseAction {
        public div(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input) {
            System.out.println("----------Деление чисел----------");
            Double a = input.ask("Введите первое число: ");
            Double b = input.ask("Введите второе число: ");
            calculator.div(a, b);
            System.out.println("Итого: " + calculator.getResult());
        }
    }

    public class add extends BaseAction {
        public add(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input) {
            System.out.println("----------Суммирование чисел----------");
            Double a = input.ask("Введите первое число: ");
            Double b = input.ask("Введите второе число: ");
            calculator.add(a, b);
            System.out.println("Итого: " + calculator.getResult());
        }
    }

    public class subtract extends BaseAction {
        public subtract(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input) {
            System.out.println("----------Вычетание чисел----------");
            Double a = input.ask("Введите первое число: ");
            Double b = input.ask("Введите второе число: ");
            calculator.subtract(a, b);
            System.out.println("Итого: " + calculator.getResult());
        }
    }

    public class multiple extends BaseAction {
        public multiple(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input) {
            System.out.println("----------Умножение чисел----------");
            Double a = input.ask("Введите первое число: ");
            Double b = input.ask("Введите второе число: ");
            calculator.multiple(a, b);
            System.out.println("Итого: " + calculator.getResult());
        }
    }


}

