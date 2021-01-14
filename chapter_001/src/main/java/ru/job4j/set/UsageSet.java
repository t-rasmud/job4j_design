package ru.job4j.set;

import java.util.*;

public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
            System.out.println("Текущий элемент: " + it.next());
        }
        strings.stream()
                .filter(s -> s.length() < 5)
                .forEach(st -> System.out.println("Текущий элемент: " + st));
    }
}
