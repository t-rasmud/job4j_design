package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int point = 0;
    private int freeCells;

    public ArrayIterator(T[] array, int freeCells) {
        this.array = array;
        this.freeCells = freeCells;
    }

    @Override
    public boolean hasNext() {
        return point < array.length - freeCells;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[point++];
    }
}
