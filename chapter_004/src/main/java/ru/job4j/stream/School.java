package ru.job4j.stream;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Students> collect(List<Students> students, Predicate<Students> predicate) {
        return students.stream().
                filter(predicate).
                collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 5);
        Integer b = list.stream().reduce(10, (acc, y) -> acc + y);
        System.out.println(b);
    }
}
