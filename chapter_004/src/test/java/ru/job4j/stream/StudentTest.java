package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void whenListConvertNewList() {
        List<Student> start = List.of(
                new Student("test1", 40),
                new Student("test2", 66),
                new Student("test3", 70));

        List<Student> result = List.of(
                new Student("test3", 70),
                new Student("test2", 66));
        assertThat(Student.levelOf(start, 50), is(result));
    }

    @Test
    public void whenAddNullThanNullNotInResult() {
        List<Student> start = new ArrayList<>();
        start.add(new Student("test1", 2));
        start.add(new Student("test2", 6));
        start.add(null);
        List<Student> result = List.of(
                new Student("test2", 6)
        );
        assertThat(Student.levelOf(start, 5), is(result));
    }


    //1
    //2

}
