package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String questions) {
        System.out.println(questions);
        return scanner.nextLine();
    }

    @Override
    public int ask(String questions, int ranges[])  {
        int key = Integer.valueOf(this.ask(questions));
        boolean exit = false;
        for (int value : ranges) {
            if (value == key) {
                exit = true;
                break;
            }
        }
        if (!exit) {
            throw new MenuOutException("Out of menu ranges");
        }
        return key;
        }
}