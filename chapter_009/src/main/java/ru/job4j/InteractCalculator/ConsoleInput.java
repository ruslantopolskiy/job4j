package ru.job4j.InteractCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    private int a, b;

    @Override
    public String ask(String text) {
        boolean result = false;
        do {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Введите первое число: ");
                a = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Введите второе число: ");
                b = Integer.parseInt(bufferedReader.readLine());
                result = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Введено не число, попробуйте ещё раз!");
            } catch (IOException e) {
                e.getStackTrace();
            }
        } while (!result);
        return null;
    }
}
