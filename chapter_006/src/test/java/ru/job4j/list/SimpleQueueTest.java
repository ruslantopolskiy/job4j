package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class SimpleQueueTest {
    SimpleQueue<Integer> simple = new SimpleQueue<>();
    @Before
    public void before(){
        simple.push(1);
        simple.push(2);

    }
    @Test(expected = IllegalArgumentException .class)
    public void When(){
       assertThat(simple.poll(),is(1));
        assertThat(simple.poll(),is(2));

        simple.in.poll();
    }

    @Test
    public void name() {
        assertThat(simple.poll(),is(1));
        simple.push(19);
        assertThat(simple.poll(),is(2));
    }
}