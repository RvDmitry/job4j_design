package ru.job4j.design.lsp.store;

import org.junit.After;
import org.junit.Test;
import ru.job4j.design.lsp.model.Bakery;
import ru.job4j.design.lsp.model.Food;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class TrashTest
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class TrashTest {

    @After
    public void clear() {
        new Trash().delete();
    }

    @Test
    public void whenAcceptTrue() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(5),
                LocalDate.now().minusDays(1),
                30
        );
        Store store = new Trash();
        assertTrue(store.accept(food));
    }

    @Test
    public void whenAcceptFalse() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(1),
                LocalDate.now(),
                30
        );
        Store store = new Trash();
        assertFalse(store.accept(food));
    }

    @Test
    public void whenGet() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(5),
                LocalDate.now().minusDays(1),
                30
        );
        Store store = new Trash();
        store.accept(food);
        assertThat(store.get().get(0), is(food));
    }
}