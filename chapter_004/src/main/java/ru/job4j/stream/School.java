package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Students> collect(List<Students> students, Predicate<Students> predicate){
        return students.stream().
                filter(predicate).
                collect(Collectors.toList());

    }
}
