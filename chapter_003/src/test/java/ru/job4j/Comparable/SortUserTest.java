package ru.job4j.Comparable;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAgeThenSortAge() {
        SortUser sortUser = new SortUser();
        List<User> list = Arrays.asList(
                new User("Руслан", 2),
                new User("Вася", 44),
                new User("Вадим", 22));
        Set<User> set = new TreeSet<>();
        set.add(new User("Руслан", 2));
        set.add(new User("Вадим", 22));
        set.add(new User("Вася", 44));
        assertThat(sortUser.sort(list), is(set));
    }

    @Test
    public void whenAgeThenSortNameAge() {
        SortUser sortUser = new SortUser();
        List<User> list = Arrays.asList(
                new User("Руслан", 2),
                new User("Алекc", 44),
                new User("Алекc", 22));
                new User("Яков",40);
        List<User> set = new ArrayList<>();
        set.add(new User("Алекс", 22));
        set.add(new User("Алекся", 44));
        set.add(new User("Руслан",2));
        set.add(new User("Яков", 40));
        assertThat(sortUser.sortByAllFields(list), is(set));
    }

}