package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class MaxMinTest
 * Класс тестирует поиск элементов в коллекции.
 * @author Dmitry Razumov
 * @version 1
 */
public class MaxMinTest {

    private List<Integer> nums = List.of(1, 2, 5, 4, 3);
    private Comparator<Integer> comp = Integer::compare;
    private MaxMin mm = new MaxMin();

    @Test
    public void whenMax() {
        assertThat(mm.max(nums, comp), is(5));
    }

    @Test
    public void whenMin() {
        assertThat(mm.min(nums, comp), is(1));
    }

    @Test
    public void whenMaxListIsNull() {
        assertNull(mm.max(null, null));
    }

    @Test
    public void whenMinListIsNull() {
        assertNull(mm.min(null, null));
    }
}