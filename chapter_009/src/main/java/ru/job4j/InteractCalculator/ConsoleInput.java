package ru.job4j.InteractCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Double[] massive;

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
    public Double ask(String text) {
        double child;
        while (true){
            try {
                System.out.println(text);
                child = Double.parseDouble(bufferedReader.readLine());
                bufferedReader.close();
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Введено не число, попрубуйте ещё раз!");
                nfe.getStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return child;
    }

}

