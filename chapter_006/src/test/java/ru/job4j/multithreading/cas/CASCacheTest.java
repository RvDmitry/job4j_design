package ru.job4j.multithreading.cas;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CASCacheTest {

    @Test
    public void whenAddToCacheThenTrue() {
        CASCache cache = new CASCache();
        Base model = new Base(1, 1, "Model");
        assertTrue(cache.add(model));
        assertThat(cache.getSize(), is(1));
    }

    @Test
    public void whenAddToCacheThenFalse() {
        CASCache cache = new CASCache();
        Base model1 = new Base(1, 1, "Model1");
        Base model2 = new Base(1, 1, "Model2");
        cache.add(model1);
        assertFalse(cache.add(model2));
    }

    @Test
    public void whenDeleteFromCacheThenTrue() {
        CASCache cache = new CASCache();
        Base model = new Base(1, 1, "Model");
        cache.add(model);
        assertTrue(cache.delete(model));
        assertThat(cache.getSize(), is(0));
    }

    @Test
    public void whenDeleteFromCacheThenFalse() {
        CASCache cache = new CASCache();
        Base model = new Base(1, 1, "Model");
        assertFalse(cache.delete(model));
    }

    @Test
    public void whenUpdateCacheThenTrue() {
        CASCache cache = new CASCache();
        Base model = new Base(1, 1, "Model");
        cache.add(model);
        model.setName("NewName");
        assertTrue(cache.update(model));
        assertThat(model.getVersion(), is(2));
    }

    @Test
    public void whenUpdateCacheThenFalse() {
        CASCache cache = new CASCache();
        Base model = new Base(1, 1, "Model");
        assertFalse(cache.update(model));
    }

    @Test
    public void whenThrowException() throws InterruptedException {
        CASCache cache = new CASCache();
        Base model1 = new Base(1, 1, "Model1");
        Base model2 = new Base(1, 1, "Model2");
        Base model3 = new Base(1, 1, "Model3");
        cache.add(model1);
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        cache.update(model3);
                    } catch (OptimisticException e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        try {
            cache.update(model2);
        } catch (OptimisticException e) {
            ex.set(e);
        }
        thread.join();
        assertThat(ex.get().getMessage(), is("Модель была изменена."));
    }
}