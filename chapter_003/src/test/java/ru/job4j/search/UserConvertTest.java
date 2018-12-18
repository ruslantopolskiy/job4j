package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class UserConvertTest {
    @Test
    public void whenListThenMap() {
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User("Ruslan", "0", "Tver"));
        list.add(new User("Sergey", "1", "Moscou"));
        list.add(new User("Alina", "2", "Klin"));
        assertThat(userConvert.process(list).get(0).getName(), is("Ruslan"));


    }
}
