package ru.job4j.InteractCalculator;

import ru.job4j.calculator.Calculator;

import java.util.ArrayList;
import java.util.List;

public class MenuCalculator {
    private final Calculator calculator;

    public MenuCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    List<UserAction> list = new ArrayList<>();

    void set() {
        list.add(1,new add(1,"Суммирование"));
        list.add(4, new div(4, "Деление"));
    }



    private abstract class BaseAction implements UserAction {
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
        }
    }


}

