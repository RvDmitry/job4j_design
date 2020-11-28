package ru.job4j.multithreading.cas;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class CASCountTest
 * Класс тестирует потокобезопасный неблокирующий счетчик.
 * @author Dmitry Razumov
 * @version 1
 */
public class CASCountTest {

    @Test
    public void when1IncrementThenGet1() {
        CASCount count = new CASCount();
        count.increment();
        assertThat(count.get(), is(1));
    }

    @Test
    public void when3IncrementThenGet3() {
        CASCount count = new CASCount();
        count.increment();
        count.increment();
        count.increment();
        assertThat(count.get(), is(3));
    }

    @Test
    public void whenTwoThreadsUseCounter() throws InterruptedException {
        CASCount count = new CASCount();
        Thread first = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                count.increment();
            }
        });
        Thread second = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                count.increment();
            }
        });
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(count.get(), is(10));
    }
}