package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class AnalizeTest
 * Класс тестирует анализ коллекций пользователей.
 * @author Dmitry Razumov
 * @version 1
 */
public class AnalizeTest {
    private List<Analize.User> prev;
    private final Analize analize = new Analize();

    @Before
    public void setUp() {
        prev = Arrays.asList(
                new Analize.User(1, "User 1"),
                new Analize.User(2, "User 2"),
                new Analize.User(3, "User 3")
        );
    }

    @Test
    public void whenUserNoChange() {
        Analize.Info info = analize.diff(prev, prev);
        assertThat(info.getAdded(), is(0));
        assertThat(info.getChanged(), is(0));
        assertThat(info.getDeleted(), is(0));
    }

    @Test
    public void whenUserAdd() {
        List<Analize.User> current = new ArrayList<>(prev);
        current.add(new Analize.User(4, "User 4"));
        current.add(new Analize.User(5, "User 5"));
        Analize.Info info = analize.diff(prev, current);
        assertThat(info.getAdded(), is(2));
        assertThat(info.getChanged(), is(0));
        assertThat(info.getDeleted(), is(0));
    }

    @Test
    public void whenUserChange() {
        List<Analize.User> current = new ArrayList<>(prev);
        Analize.User user = new Analize.User(2, "New User");
        current.set(1, user);
        Analize.Info info = analize.diff(prev, current);
        assertThat(info.getAdded(), is(0));
        assertThat(info.getChanged(), is(1));
        assertThat(info.getDeleted(), is(0));
    }

    @Test
    public void whenUserDelete() {
        List<Analize.User> current = new ArrayList<>(prev);
        current.remove(2);
        Analize.Info info = analize.diff(prev, current);
        assertThat(info.getAdded(), is(0));
        assertThat(info.getChanged(), is(0));
        assertThat(info.getDeleted(), is(1));
    }
}