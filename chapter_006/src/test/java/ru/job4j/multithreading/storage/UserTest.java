package ru.job4j.multithreading.storage;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class UserTest
 * @author Dmitry Razumov
 * @version 1
 */
public class UserTest {

    @Test
    public void whenGetId() {
        User user = new User(1, 10);
        assertThat(user.getId(), is(1));
    }

    @Test
    public void whenGetAmount() {
        User user = new User(1, 10);
        assertThat(user.getAmount(), is(10));
    }

    @Test
    public void whenSetAmount() {
        User user = new User(1, 10);
        user.setAmount(20);
        assertThat(user.getAmount(), is(20));
    }
}