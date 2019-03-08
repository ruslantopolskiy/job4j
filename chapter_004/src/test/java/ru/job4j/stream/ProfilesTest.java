package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class ProfilesTest {
    Profiles profiles;
    List<Profile> list = List.of(new Profile(new Address("Москва","Street",1,1)),
                                 new Profile(new Address("Тверь","Street",2,2)));

    List<Address> result = Arrays.asList(new Address("Москва", "Street", 1, 1),
                                         new Address("Тверь", "Street", 2, 2));

    @Before
    public void before(){
        profiles = new Profiles();
    }

    @Test
    public void WhenAddAddres() {
        assertThat(profiles.collect(list), is(result));
    }
    }
