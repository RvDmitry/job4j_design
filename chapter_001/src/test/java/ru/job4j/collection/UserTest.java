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
        GregorianCalendar birthday = new GregorianCalendar(2000, 02, 10);
        User user = new User("Ivan", birthday);
        user.setChildren(1);
        assertThat(user.getName(), is("Ivan"));
        assertThat(user.getChildren(), is(1));
        assertThat(user.getBirthday(), is(birthday));
    }
}