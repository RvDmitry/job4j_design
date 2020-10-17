package ru.job4j.design.lsp.storage.store;

import org.junit.After;
import org.junit.Test;
import ru.job4j.design.lsp.storage.model.Bakery;
import ru.job4j.design.lsp.storage.model.Food;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class WarehouseTest
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class WarehouseTest {

    @After
    public void clear() {
        new Warehouse().delete();
    }

    @Test
    public void whenAcceptTrue() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(10),
                30
        );
        Store store = new Warehouse();
        assertTrue(store.accept(food));
    }

    @Test
    public void whenAcceptFalse() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(10),
                30
        );
        Store store = new Warehouse();
        assertFalse(store.accept(food));
    }

    @Test
    public void whenGet() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(10),
                30
        );
        Store store = new Warehouse();
        store.accept(food);
        assertThat(store.get().get(0), is(food));
    }
}