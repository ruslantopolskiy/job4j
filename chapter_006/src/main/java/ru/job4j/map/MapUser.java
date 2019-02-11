package ru.job4j.map;

import java.util.GregorianCalendar;

public class MapUser {

    public static void main(String[] args) {
        User first = new User("Oleg", 21, new GregorianCalendar(1990, 9, 21));
        User second = new User("Oleg", 21, new GregorianCalendar(1990, 9, 21));
        System.out.println(first.equals(second));
    }
}
