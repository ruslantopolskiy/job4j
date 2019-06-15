package ru.job4j.OtherCalculator;

import java.util.HashMap;
import java.util.Map;

public class MenuCalculator {
    int result;
    Input input;
    Map<String, Operation> map = new HashMap<>();

    public MenuCalculator(Input input) {
        this.input = input;
    }

    public void mapInit() {
        map.put("+", new Add());
        map.put("-", new Subtract());
        map.put("*", new Multiple());
        map.put("/", new Div());
    }

    public void show(){
        System.out.println("------Калькулятор------");
        for (String s : map.keySet()){
            if (s !=null)
            System.out.println(s);
        }
    }

    public void select(String key){
        map.get(key).execute("Введите число(а): ");
    }

    public class Add implements Operation {
        @Override
        public void execute(String text) {
            System.out.println(text);
            System.out.println();
            int a = input.ask("Введите первое число");
            int b = input.ask("Введите второе число");
            result = a + b;
            System.out.println("Результат вычисления: " + result);
        }
    }

    public class Subtract implements Operation {
        @Override
        public void execute(String text) {
            System.out.println(text);
            System.out.println();
            int a = input.ask("Введите первое число");
            int b = input.ask("Введите второе число");
            result = a-b;
            System.out.println("Результат вычисления: " + result);

        }
    }

    public class Multiple implements Operation {
        @Override
        public void execute(String text) {
            System.out.println(text);
            System.out.println();
           int a = input.ask("Введите первое число");
           int b = input.ask("Введите второе число");
            result = a * b;
            System.out.println("Результат вычисления: " + result);

        }
    }

    public class Div implements Operation {
        @Override
        public void execute(String text) {
            System.out.println(text);
            System.out.println();
            int a = input.ask("Введите первое число");
            int b = input.ask("Введите второе число");
           result = a/b;
            System.out.println("Результат вычисления: " + result);

        }
    }
}
