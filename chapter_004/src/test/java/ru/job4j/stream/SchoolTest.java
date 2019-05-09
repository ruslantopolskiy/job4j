package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    School school = new School();
    List<Students> list = List.of(
            new Students(71),
            new Students(50),
            new Students(0),
            new Students(85),
            new Students(33),
            new Students(6));

    @Test
    public void whenAdd70ScoreThenClassA() {
        List<Students> list1 = school.collect(list, x -> x.getScore() >= 70);
        assertThat(list1.size(), is(2));
    }

    @Test
    public void whenAddScoreThenClassB() {
        List<Students> list1 = school.collect(list, x -> x.getScore() >= 50 && x.getScore() < 70);
        assertThat(list1.size(), is(1));
    }

    @Test
    public void whenAddScoreThenClassC() {
        List<Students> list1 = school.collect(list, x -> x.getScore() < 50);
        assertThat(list1.size(), is(3));
    }
}