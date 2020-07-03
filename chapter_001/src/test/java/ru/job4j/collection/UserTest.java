package ru.job4j.collection;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class UserTest
 * @author Dmitry Razumov
 * @version 1
 */
public class UserTest {

    @Test
    public void whenUser() {
        GregorianCalendar birthday = new GregorianCalendar(2000, 2, 10);
        User user = new User("Ivan", birthday);
        user.setChildren(1);
        assertThat(user.getName(), is("Ivan"));
        assertThat(user.getChildren(), is(1));
        assertThat(user.getBirthday(), is(birthday));
    }

    @Test
    public void whenUserEquals() {
        GregorianCalendar birthday = new GregorianCalendar(2000, 2, 10);
        User user1 = new User("Ivan", birthday);
        user1.setChildren(1);
        User user2 = new User("Ivan", birthday);
        user2.setChildren(1);
        assertEquals(user1, user2);
    }

    @Test
    public void whenUserNoEquals() {
        GregorianCalendar birthday = new GregorianCalendar(2000, 2, 10);
        User user1 = new User("Ivan", birthday);
        user1.setChildren(1);
        User user2 = new User("Petr", birthday);
        user2.setChildren(1);
        assertNotEquals(user1, user2);
    }

    @Test
    public void whenUserHashCode() {
        GregorianCalendar birthday = new GregorianCalendar(2000, 2, 10);
        User user1 = new User("Ivan", birthday);
        user1.setChildren(1);
        User user2 = new User("Petr", birthday);
        user2.setChildren(1);
        User user3 = new User("Ivan", birthday);
        user3.setChildren(1);
        assertEquals(user1.hashCode(), user3.hashCode());
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void whenAdd2EqualUsersToMapThen1User() {
        User user1 = new User("Ivan", new GregorianCalendar(1990, 0, 20));
        user1.setChildren(2);
        User user2 = new User("Ivan", new GregorianCalendar(1990, 0, 20));
        user2.setChildren(2);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        assertThat(map.size(), is(1));
    }
}