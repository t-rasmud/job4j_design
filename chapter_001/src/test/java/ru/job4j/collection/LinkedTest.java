package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinkedTest {
    @Test
    public void whenAddThenGet() {
        Linked<String> linked = new Linked<>();
        linked.add("first");
        linked.add("second");
        String rsl = linked.get(0);
        assertThat(rsl, is("first"));
        rsl = linked.get(1);
        assertThat(rsl, is("second"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        Linked<String> linked = new Linked<>();
        linked.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        Linked<String> linked = new Linked<>();
        linked.add("first");
        linked.get(1);
    }

    @Test
    public void whenAddThenIt() {
        Linked<String> linked = new Linked<>();
        linked.add("first");
        linked.add("second");
        linked.add("third");
        Iterator<String> it = linked.iterator();
        String rsl = it.next();
        assertThat(rsl, is("first"));
        rsl = it.next();
        assertThat(rsl, is("second"));
        rsl = it.next();
        assertThat(rsl, is("third"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        Linked<String> linked = new Linked<>();
        linked.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        Linked<String> linked = new Linked<>();
        linked.add("first");
        Iterator<String> it = linked.iterator();
        linked.add("second");
        it.next();
    }
}
