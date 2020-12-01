package ru.job4j.multithreading.pools;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ParallelSearchTest {

    @Test
    public void whenSearch5From10ItemThen4() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int rsl = ParallelSearch.search(array, 5);
        assertThat(rsl, is(4));
    }

    @Test
    public void whenSearch9From14ItemThen8() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int rsl = ParallelSearch.search(array, 9);
        assertThat(rsl, is(8));
    }

    @Test
    public void whenSearch20From21ItemThen19() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                14, 15, 16, 17, 18, 19, 20, 21};
        int rsl = ParallelSearch.search(array, 20);
        assertThat(rsl, is(19));
    }

    @Test
    public void whenSearchString() {
        String[] array = {"Str1", "Str2", "Str3"};
        int rsl = ParallelSearch.search(array, "Str2");
        assertThat(rsl,  is(1));
    }
}