package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class SimpleStackTest {
    SimpleStack<Integer> simpleStack;
    @Before
    public void before(){
      simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        simpleStack.push(4);
        simpleStack.push(5);
        simpleStack.push(6);
    }

    @Test
    public void When0(){
        assertThat(simpleStack.list.get(0),is(6));
    }
    @Test
    public void When(){
        assertThat(simpleStack.list.size(),is(6));
    }

    @Test
    public void When2(){
        assertThat(simpleStack.list.get(5),is(1));
    }
    @Test
    public void When3(){
        assertThat(simpleStack.poll(),is(6));
        assertThat(simpleStack.list.size(),is(5));
    }

    @Test(expected = IllegalArgumentException .class)
    public void When4(){
        assertThat(simpleStack.poll(),is(6));
        assertThat(simpleStack.poll(),is(5));
        assertThat(simpleStack.poll(),is(4));
        assertThat(simpleStack.poll(),is(3));
        assertThat(simpleStack.poll(),is(2));
        assertThat(simpleStack.poll(),is(1));
        simpleStack.poll();
    }

@Test
    public void When5(){
        assertThat(simpleStack.poll(),is(6));
        assertThat(simpleStack.poll(),is(5));
        simpleStack.push(12);
        assertThat(simpleStack.poll(),is(12));
    }

}