package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    SimpleSet <Integer> simpleSet;

    @Before
    public void before() {
        simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(4);
    }
    @Test
    public void WhenAdd(){
        assertThat(simpleSet.sizeMassive(),is(4));
    }


}