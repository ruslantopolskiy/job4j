package ru.job4j.comparable;

import org.junit.Test;
import ru.job4j.comparable.SortUser;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAgeThenSortAge() {
        SortUser sortUser = new SortUser();
        List<User> list = List.of(
                new User("Руслан", 2),
                new User("Вася", 44),
                new User("Вадим", 22));
        Set<User> set = Set.of(
                new User("Вадим", 22),
                new User("Руслан", 2),
                new User("Вася", 44));
        assertThat(sortUser.sort(list), is(set));
    }

    @Test
    public void whenAgeThenSortNameAge() {
        SortUser sortUser = new SortUser();
        List<User> list = Arrays.asList(
                new User("Руслан", 2),
                new User("Ал", 44),
                new User("Ал", 22),
                new User("Яков", 40));
        List<User> set = Arrays.asList(
                new User("Ал", 22),
                new User("Ал", 44),
                new User("Руслан", 2),
                new User("Яков", 40));
        assertThat(sortUser.sortByAllFields(list), is(set));
    }

}