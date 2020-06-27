package ru.job4j.collection;

import org.hamcrest.core.Is;
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

    @Test
    public void whenAdd() {
        SimpleLinked<String> list = new SimpleLinked<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenGet() {
        SimpleLinked<String> list = new SimpleLinked<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertThat(list.get(1), is("B"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetWrongIndexThenException() {
        SimpleLinked<String> list = new SimpleLinked<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.get(3);
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