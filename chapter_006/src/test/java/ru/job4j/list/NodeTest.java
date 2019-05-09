package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;


import static org.junit.Assert.*;

public class NodeTest {
    Node<Integer> one1 = new Node(1);
    Node<Integer> one2 = new Node(2);
    Node<Integer> one3 = new Node(3);
    Node<Integer> one4 = new Node(4);
    Node<Integer> one5 = new Node(5);
    Node<Integer> one6 = new Node(6);

    @Before
    public void before() {
        one1.next = one2;
        one2.next = one3;
        one3.next = one4;
        one4.next = one5;
    }

    @Test
    public void when1() {
        one5.next = one6;
        assertThat(Node.hasCycle(one1), is(false));
    }

    @Test
    public void when2() {
        one5.next = one3;
        assertThat(Node.hasCycle(one1), is(true));
    }

    @Test
    public void when3() {
        one5.next = null;
        assertThat(Node.hasCycle(one1), is(false));
    }

    @Test
    public void when4() {
        one1 = null;
    }

}