package ru.job4j.collection;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class SimpleLinkedTest
 * Класс тестирует работу связного списка.
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleLinkedTest {

    private SimpleLinked<String> list;

    @Before
    public void setUp() {
        list = new SimpleLinked<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
    }

    @Test
    public void whenAdd() {
        assertThat(list.getSize(), is(4));
    }

    @Test
    public void whenGet() {
        assertThat(list.get(1), is("B"));
    }

    @Test
    public void whenGetLastIndex() {
        assertThat(list.get(3), is("D"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetWrongIndexThenException() {
        list.get(4);
    }

    @Test
    public void whenIterator() {
        SimpleLinked<Integer> list = new SimpleLinked<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(1));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(2));
        assertThat(it.hasNext(), Is.is(true));
        assertThat(it.next(), Is.is(3));
        assertThat(it.hasNext(), Is.is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorException() {
        SimpleLinked<Integer> list = new SimpleLinked<>();
        list.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCollectionChangeThenIteratorException() {
        SimpleLinked<Integer> list = new SimpleLinked<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> it = list.iterator();
        it.next();
        list.add(3);
        it.next();
    }
}