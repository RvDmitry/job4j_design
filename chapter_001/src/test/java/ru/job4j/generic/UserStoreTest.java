package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class UserStoreTest
 * Класс тестирует работу с хранилищем пользователей.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class UserStoreTest {

    private UserStore store;

    @Before
    public void setUp() {
        store = new UserStore();
        User user1 = new User("111");
        user1.setName("User1");
        User user2 = new User("222");
        user2.setName("User2");
        User user3 = new User("333");
        user3.setName("User3");
        store.add(user1);
        store.add(user2);
        store.add(user3);
    }

    @Test
    public void whenFindById() {
        User result = store.findById("222");
        assertThat(result.getName(), is("User2"));
    }

    @Test
    public void whenFindByWrongIdThenNull() {
        User result = store.findById("22");
        assertNull(result);
    }

    @Test
    public void whenDelete() {
        assertTrue(store.delete("222"));
    }

    @Test
    public void whenDeleteWrongIdThenFalse() {
        assertFalse(store.delete("33"));
    }

    @Test
    public void whenReplace() {
        User user4 = new User("444");
        user4.setName("User4");
        store.replace("222", user4);
        assertThat(store.findById("444").getName(), is("User4"));
        assertNull(store.findById("222"));
    }
}