package ru.job4j.collection;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private T[] container;
    private int modCount;

    public SimpleArray() {
        container = (T[]) new Object[10];
        modCount = 0;
    }

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
        return new SimpleArrayIterator<>(container, modCount, this);
    }

    private void grow() {
        T[] destArray = (T[]) new Object[container.length + 10];
        System.arraycopy(container, 0, destArray, 0, container.length);
        container = destArray;
    }

    private static int checkIndex(int index, int length) {
        if (index >= 0 && index < length) {
            return index;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int getModCount() {
        return modCount;
    }
}
