package ru.job4j.map;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return children == user.children &&
//                Objects.equals(name, user.name) &&
//                Objects.equals(birthday, user.birthday);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", birthday=" + dateFormat.format(birthday.getTime()) +
                '}';
    }

    public static void main(String[] args) {
        User user1 = new User("John", 2, new GregorianCalendar(1985, Calendar.APRIL, 6));
        User user2 = new User("John", 2, new GregorianCalendar(1985, Calendar.APRIL, 6));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, 1);
        map.put(user2, 2);
        System.out.println(map);
    }
}
