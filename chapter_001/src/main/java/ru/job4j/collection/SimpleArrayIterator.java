package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int point = 0;
    private int expectedModCount;
    private SimpleArray<T> containerClass;

    public SimpleArrayIterator(T[] array, int expectedModCount, SimpleArray<T> containerClass) {
        this.array = array;
        this.expectedModCount = expectedModCount;
        this.containerClass = containerClass;
    }

    @Override
    public boolean hasNext() {
        return point < expectedModCount;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (expectedModCount != containerClass.getModCount()) {
            throw new ConcurrentModificationException();
        }
        return array[point++];
    }
}
