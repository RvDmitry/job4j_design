package ru.job4j.collection;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class DeleteLastLinkedTest
 * Класс тестирует удаление последнего элемента из односвязного списка.
 * @author Dmitry Razumov
 * @version 1
 */
public class DeleteLastLinkedTest {

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteLast() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteLast();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteLast();
    }

    @Test
    public void whenDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        assertThat(linked.deleteLast(), is(2));
        assertThat(linked.deleteLast(), is(1));
    }
}
