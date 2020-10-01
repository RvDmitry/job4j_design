package ru.job4j.gc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Class SoftCacheTest
 * Класс тестирует SoftCache.
 * @author Dmitry Razumov
 * @version 1
 */
public class SoftCacheTest {
    @Test
    public void whenCachePutAndGet() {
        SoftCache cache = new SoftCache(null);
        cache.put("key", "value");
        assertThat(cache.get("key"), is("value"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFileNotExist() {
        SoftCache cache = new SoftCache(null);
        cache.get("key");
    }

    @Test
    public void whenCacheGetPreviousValue() {
        SoftCache cache = new SoftCache(null);
        cache.put("key", "value");
        assertThat(cache.put("key", "value 2"), is("value"));
    }
}