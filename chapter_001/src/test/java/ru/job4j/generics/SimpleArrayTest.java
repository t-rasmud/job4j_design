package ru.job4j.generics;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

public class SimpleArrayTest {
    @Test
    public void whenAdd() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (Iterator<?> it = arr.iterator(); it.hasNext(); ) {
            Object next = it.next();
            System.out.println(next);
        }
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("1" + ln + "2" + ln + "3" + ln));
    }

    @Test
    public void whenAddWithOutOfBounds() {
        SimpleArray<String> arr = new SimpleArray<>(3);
        arr.add("one");
        arr.add("two");
        arr.add("three");
        arr.add("four");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (Iterator<?> it = arr.iterator(); it.hasNext(); ) {
            Object next = it.next();
            System.out.println(next);
        }
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("one" + ln + "two" + ln + "three" + ln));
    }

    @Test
    public void whenSet() {
        SimpleArray<Integer> arr = new SimpleArray<>(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.set(2, 0);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (Iterator<?> it = arr.iterator(); it.hasNext(); ) {
            Object next = it.next();
            System.out.println(next);
        }
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("1" + ln + "2" + ln + "0" + ln + "4" + ln));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenSetWithIndexOutOfBounds() {
        SimpleArray<Integer> arr = new SimpleArray<>(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.set(4, 0);
    }

    @Test
    public void whenRemove() {
        SimpleArray<Integer> arr = new SimpleArray<>(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.remove(1);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (Iterator<?> it = arr.iterator(); it.hasNext(); ) {
            Object next = it.next();
            System.out.println(next);
        }
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("1" + ln + "3" + ln + "4" + ln + "null" + ln));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveWithIndexOutOfBounds() {
        SimpleArray<Integer> arr = new SimpleArray<>(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.remove(-1);
    }

    @Test
    public void whenGet() {
        SimpleArray<Integer> arr = new SimpleArray<>(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        Integer rsl = arr.get(2);
        assertThat(rsl, is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetWithIndexOutOfBounds() {
        SimpleArray<Integer> arr = new SimpleArray<>(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        Integer rsl = arr.get(4);
    }
}
