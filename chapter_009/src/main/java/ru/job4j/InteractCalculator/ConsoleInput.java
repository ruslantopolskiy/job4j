package ru.job4j.InteractCalculator;

import ru.job4j.calculator.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    Calculator calculator = new Calculator();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String askExit(String text) {
        System.out.println(text);
        String result = null;
        try {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public double ask(String text) {
        String child;
        double result = 0;
        while (true) {
            try {
                System.out.println(text);
                child = bufferedReader.readLine();
                if (child.equalsIgnoreCase("prev")) {
                    result =(calculator.getResult());
                }else {
                    result = Double.parseDouble(child);
                }
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Введено не число, попрубуйте ещё раз!");
                nfe.getStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return result;
    }

}

