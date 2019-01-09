package ru.job4j.streamApi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void whenListConvertNewList() {
        List<Student> start = List.of(
                new Student("AL1", 40),
                new Student("AL2", 66),
                new Student("AL3", 70));

        List<Student> result = List.of(
                new Student("AL2", 66),
                new Student("AL3", 70));
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

}
