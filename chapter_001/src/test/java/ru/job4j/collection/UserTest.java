package ru.job4j.collection;

import org.junit.Test;

import java.util.GregorianCalendar;

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
        assertThat(user1, is(user2));
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
}