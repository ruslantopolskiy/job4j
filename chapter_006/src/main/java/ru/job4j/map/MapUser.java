package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapUser {
    User first = new User("Oleg", 21, new GregorianCalendar(1990, 9, 21));
    User second = new User("Oleg", 21, new GregorianCalendar(1990, 9, 21));
    Map<User, Object> map = new HashMap<>();

    public void print() {
        map.put(first, (int) 1);
        map.put(second, (int) 2);
        System.out.println(map);
        System.out.println(first.equals(second));
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, map);
    }

    public static void main(String[] args) {
        MapUser mapUser = new MapUser();
        mapUser.print();
    }
}
