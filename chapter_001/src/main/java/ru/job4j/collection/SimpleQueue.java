package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countIn = 0;

    public T poll() {
        if (countIn == 0) {
            throw new NoSuchElementException();
        }
        int countOut = countIn - 1;
        while (countIn > 0) {
            out.push(in.pop());
            countIn--;
        }
        T rsl = out.pop();
        while (countOut > 0) {
            in.push(out.pop());
            countOut--;
            countIn++;
        }
        return rsl;
    }

    public void push(T value) {
        in.push(value);
        countIn++;
    }
}
