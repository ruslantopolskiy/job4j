package ru.job4j.OtherCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int result;
    @Override
    public int ask(String text) {
        while (true){
            try {
                System.out.println(text);
                result = Integer.parseInt(bufferedReader.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Пожалуйста, введите значение Integer");
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public String askString(String text) {
        System.out.println(text);
        String result = null;
        try {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
