package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String questions) {
        System.out.println(questions);
        return scanner.nextLine();
    }
}