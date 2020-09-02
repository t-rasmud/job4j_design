package ru.job4j.it;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (cursor != null) {
            while (!cursor.hasNext() && data.hasNext()) {
                cursor = data.next();
            }
        }
        return cursor != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T rsl = cursor.next();
        while (cursor != null && !cursor.hasNext()) {
            cursor = data.hasNext() ? data.next() : null;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = Arrays.asList(
                Arrays.asList(1, 2, 3).iterator(),
                Arrays.asList(4, 5, 6).iterator(),
                Arrays.asList(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}