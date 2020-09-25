package ru.job4j.generics;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private T[] arr;
    private int freeCells;

    public SimpleArray(int length) {
        this.arr = (T[]) new Object[length];
        freeCells = length;
    }

    public void add(T model) {
        if (freeCells == 0) {
            return;
        }
        arr[arr.length - freeCells] = model;
        freeCells--;
    }

    public void set(int index, T model) {
        checkIndex(index, arr.length - freeCells);
        arr[index] = model;
    }

    public void remove(int index) {
        checkIndex(index, arr.length - freeCells);
        for (int i = index; i < arr.length - freeCells - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - freeCells - 1] = null;
        freeCells++;
    }

    public T get(int index) {
        checkIndex(index, arr.length - freeCells);
        return arr[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(arr);
    }

    private static int checkIndex(int index, int length) {
        if (index >= 0 && index < length) {
            return index;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
