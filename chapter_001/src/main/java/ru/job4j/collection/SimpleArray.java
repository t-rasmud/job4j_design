package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private T[] container = (T[]) new Object[10];
    private int modCount = 0;

    public T get(int index) {
        checkIndex(index, modCount);
        return container[index];
    }

    public void add(T model) {
        if (modCount == container.length) {
            grow();
        }
        container[modCount] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    private void grow() {
        T[] destArray = (T[]) new Object[container.length + container.length / 2];
        System.arraycopy(container, 0, destArray, 0, container.length);
        container = destArray;
    }

    private static int checkIndex(int index, int length) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        return index;
    }

    private class SimpleArrayIterator implements Iterator<T> {
        private int point = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return point < expectedModCount;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return container[point++];
        }
    }
}
