package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class SimpleSetTest
 * Класс тестирует работу коллекции SimpleSet.
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleSetTest {

    @Test
    public void whenAdd() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenSameAdd() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorException() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.iterator().next();
    }

    @Test
    public void whenNullAdd() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(null);
        set.add(null);
        set.add(2);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertNull(it.next());
        assertThat(it.next(), is(2));
    }
}