package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class RoleStoreTest
 * Класс тестирует хранилище ролей.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class RoleStoreTest {

    private RoleStore store;

    @Before
    public void setUp() {
        store = new RoleStore();
        Role role1 = new Role("1");
        role1.setRole("Role 1");
        Role role2 = new Role("2");
        role2.setRole("Role 2");
        Role role3 = new Role("3");
        role3.setRole("Role 3");
        store.add(role1);
        store.add(role2);
        store.add(role3);
    }

    @Test
    public void whenFindById() {
        Role result = store.findById("2");
        assertThat(result.getRole(), is("Role 2"));
    }

    @Test
    public void whenFindByWrongIdThenNull() {
        Role result = store.findById("22");
        assertNull(result);
    }

    @Test
    public void whenDelete() {
        assertTrue(store.delete("2"));
    }

    @Test
    public void whenDeleteWrongIdThenFalse() {
        assertFalse(store.delete("33"));
    }

    @Test
    public void whenReplace() {
        Role role4 = new Role("4");
        role4.setRole("Role 4");
        store.replace("2", role4);
        assertThat(store.findById("4").getRole(), is("Role 4"));
        assertNull(store.findById("2"));
    }
}