package ru.job4j.storage;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class UserStoreTest
 * @author Dmitry Razumov
 * @version 1
 */
public class UserStoreTest {

    @Test
    public void whenUserAddTrue() {
        User user = new User(1, 10);
        UserStore store = new UserStore();
        assertTrue(store.add(user));
    }

    @Test
    public void whenUserAddFalse() {
        User user = new User(1, 10);
        UserStore store = new UserStore();
        store.add(user);
        assertFalse(store.add(user));
    }

    @Test
    public void whenUserUpdateTrue() {
        User user = new User(1, 10);
        UserStore store = new UserStore();
        store.add(user);
        user.setAmount(10);
        assertTrue(store.update(user));
    }

    @Test
    public void whenUserUpdateFalse() {
        User user = new User(1, 10);
        UserStore store = new UserStore();
        user.setAmount(10);
        assertFalse(store.update(user));
    }

    @Test
    public void whenUserDeleteTrue() {
        User user = new User(1, 10);
        UserStore store = new UserStore();
        store.add(user);
        assertTrue(store.delete(user));
    }

    @Test
    public void whenUserDeleteFalse() {
        User user = new User(1, 10);
        UserStore store = new UserStore();
        assertFalse(store.delete(user));
    }

    @Test
    public void whenTransferTrue() {
        User first = new User(1, 100);
        User second = new User(2, 200);
        UserStore stoge = new UserStore();
        stoge.add(first);
        stoge.add(second);
        stoge.transfer(1, 2, 50);
        assertThat(first.getAmount(), is(50));
        assertThat(second.getAmount(), is(250));
    }

    @Test
    public void whenTransferFalse() {
        User first = new User(1, 100);
        User second = new User(2, 200);
        UserStore stoge = new UserStore();
        stoge.add(first);
        stoge.add(second);
        assertFalse(stoge.transfer(1, 2, 150));
    }
}