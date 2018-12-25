package ru.job4j.Comparable;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAgeThenSortAge() {
        SortUser sortUser = new SortUser();
        List<User> list = Arrays.asList(
                new User("Руслан", 2),
                new User("Вася", 10),
                new User("Вадим", 22));
        Set<User> set = new TreeSet<>();
        set.add(new User("Руслан", 2));
        set.add(new User("Вася", 10));
        set.add(new User("Вадим", 22));
        assertThat(sortUser.sort(list), is(set));
    }
}