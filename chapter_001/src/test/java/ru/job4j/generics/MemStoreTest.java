package ru.job4j.generics;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MemStoreTest {
    @Test
    public void whenAdd() {
        MemStore<User> store = new MemStore<>();
        store.add(new User("1"));
        store.add(new User("2"));
        store.add(new User("3"));
        List<User> list = store.getMem();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (User user : list) {
            System.out.println(user.getId());
        }
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("1" + ln + "2" + ln + "3" + ln));
    }

    @Test
    public void whenReplace() {
        MemStore<User> store = new MemStore<>();
        store.add(new User("1"));
        store.add(new User("2"));
        store.add(new User("3"));
        store.replace("2", new User("4"));
        List<User> list = store.getMem();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (User user : list) {
            System.out.println(user.getId());
        }
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("1" + ln + "4" + ln + "3" + ln));
    }

    @Test
    public void whenDelete() {
        MemStore<User> store = new MemStore<>();
        store.add(new User("1"));
        store.add(new User("2"));
        store.add(new User("3"));
        store.delete("2");
        List<User> list = store.getMem();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        for (User user : list) {
            System.out.println(user.getId());
        }
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("1" + ln + "3" + ln));
    }

    @Test
    public void whenFindById() {
        MemStore<User> store = new MemStore<>();
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        store.add(user1);
        store.add(user2);
        store.add(user3);
        assertThat(store.findById("2"), is(user2));
    }
}
