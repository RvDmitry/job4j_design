package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class SimpleArrayTest
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleArrayTest {

    @Test
    public void whenTypeStringShouldReturnString() {
        SimpleArray<String> simple = new SimpleArray<>(10);
        simple.add("test");
        String result = simple.get(0);
        assertThat(result, is("test"));
    }

    @Test
    public void whenTypeIntShouldReturnInt() {
        SimpleArray<Integer> simple = new SimpleArray<>(10);
        simple.add(1);
        int result = simple.get(0);
        assertThat(result, is(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetException() {
        SimpleArray<Integer> simple = new SimpleArray<>(10);
        simple.add(1);
        simple.get(1);
    }

    @Test
    public void whenSet() {
        SimpleArray<Integer> simple = new SimpleArray<>(10);
        simple.add(1);
        simple.set(0, 2);
        int result = simple.get(0);
        assertThat(result, is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenSetException() {
        SimpleArray<Integer> simple = new SimpleArray<>(10);
        simple.add(1);
        simple.set(1, 2);
    }

    @Test
    public void whenRemove() {
        SimpleArray<Integer> simple = new SimpleArray<>(10);
        simple.add(1);
        simple.add(2);
        simple.add(3);
        simple.add(4);
        simple.remove(2);
        int result = simple.get(2);
        assertThat(result, is(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveException() {
        SimpleArray<Integer> simple = new SimpleArray<>(10);
        simple.add(1);
        simple.add(2);
        simple.add(3);
        simple.add(4);
        simple.remove(4);
    }

    @Test
    public void whenIterator() {
        SimpleArray<Integer> simple = new SimpleArray<>(10);
        simple.add(1);
        simple.add(2);
        simple.add(3);
        simple.add(4);
        Iterator<Integer> it = simple.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }
}