package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class UserStoreTest {
    @Test
    public void whenAddAndFindById() {
        Store<User> store = new UserStore();
        User user1 = new User("1");
        store.add(user1);
        assertThat(store.findById("1"), is(user1));
        assertNull(store.findById("2"));
    }

    @Test
    public void whenReplace() {
        Store<User> store = new UserStore();
        User user1 = new User("1");
        User user2 = new User("2");
        store.add(user1);
        store.replace("1", user2);
        assertThat(store.findById("2"), is(user2));
    }

    @Test
    public void whenDelete() {
        Store<User> store = new UserStore();
        User user1 = new User("1");
        store.add(user1);
        store.delete("1");
        assertNull(store.findById("1"));
    }
}
