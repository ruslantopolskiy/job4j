package ru.job4j.calculator;

/* Используя класс Calculator.
1. Сделать класс InteractCalc.
2. В классе должен быть пользовательский ввод.
3. Повторный выбор операции и переиспользование предыдущего вычисления.
4. Проект должен следовать SRP.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractCalc extends Calculator {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Calculator calculator = new Calculator();
    private static final String exit = "EXIT";
    private static final String previousResult = "prevResult";


    public void start()  {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String text;
            while (!(text = bufferedReader.readLine()).equals(exit)){
                System.out.println(actions(text));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String actions (String value){
        String result = null;
        if (value.contains(previousResult)) {
            value = value.replace(previousResult, Double.toString(calculator.getResult()));
        }
        String[] calculateNumbers = value.split(" ");
        if (calculateNumbers.length < 3) {
            System.out.println("Некоретный ввод, введите ещё раз.");
        } else {
            result = calculateFinish(Double.parseDouble(calculateNumbers[0]), Double.parseDouble(calculateNumbers[2]), calculateNumbers[1]);
        }
        return result;
    }


    public String calculateFinish(double a1, double a2, String operation) {
        switch (operation) {
            case "+":
                calculator.add(a1, a2);
                break;
            case "-":
                calculator.subtract(a1, a2);
                break;
            case "*":
                calculator.multiple(a1, a2);
                break;
            case "/":
                calculator.div(a1, a2);
                break;
        }


        return Double.toString(calculator.getResult());
    }


    public static void main(String[] args) {
        InteractCalc interactCalc = new InteractCalc();
        interactCalc.start();
    }


}
