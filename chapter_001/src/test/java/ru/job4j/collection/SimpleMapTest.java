package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class SimpleMapTest
 * Класс тестирует коллекцию SimpleMap.
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleMapTest {

    @Test
    public void whenInsertThenTrue() {
        SimpleMap<String, String> map = new SimpleMap<>();
        boolean rsl = map.insert("One", "Dublin");
        assertTrue(rsl);
    }

    @Test
    public void whenInsertExistingKeyThenFalse() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("One", "Dublin");
        boolean rsl = map.insert("One", "London");
        assertFalse(rsl);
        assertThat(map.get("One"), is("Dublin"));
    }

    @Test
    public void whenGetExistKey() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("One", "Dublin");
        map.insert("Two", "Canada");
        assertThat(map.get("One"), is("Dublin"));
        assertThat(map.get("Two"), is("Canada"));
    }

    @Test
    public void whenGetNoExistKeyThenNull() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("One", "Dublin");
        assertNull(map.get("Two"));
    }

    @Test
    public void whenDeleteThenTrue() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("Two", "London");
        assertTrue(map.delete("Two"));
        assertNull(map.get("Two"));
    }

    @Test
    public void whenDeleteThenFalse() {
        SimpleMap<String, String> map = new SimpleMap<>();
        assertFalse(map.delete("Three"));
    }

    @Test
    public void whenIterator() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("One", "Dublin");
        Iterator<String> it = map.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), is("Dublin"));
        assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorException() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenChangeAfterIteratorThenException() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("One", "Dublin");
        Iterator<String> it = map.iterator();
        map.insert("Two", "London");
        it.next();
    }

    @Test
    public void whenResize() {
        SimpleMap<String, String> map = new SimpleMap<>();
        for (int i = 1; i <= 20; i++) {
            map.insert("Key" + i, "Value" + i);
        }
        assertThat(map.get("Key5"), is("Value5"));
    }
}