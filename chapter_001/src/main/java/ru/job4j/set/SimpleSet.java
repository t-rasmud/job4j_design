package ru.job4j.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> simpleArray = new SimpleArray<>();

    public void add(T model) {
        if (!contains(model)) {
            simpleArray.add(model);
        }
    }

    public boolean contains(T value) {
        for (Object o : simpleArray) {
            if (Objects.equals(o, value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}
