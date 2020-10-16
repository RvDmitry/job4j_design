package ru.job4j.design.lsp.store;

import org.junit.Test;
import ru.job4j.design.lsp.model.Dairy;
import ru.job4j.design.lsp.model.Food;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class ShopTest
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class ShopTest {

    private final Food food = new Dairy(
            "Молоко",
            LocalDate.now().minusDays(1),
            LocalDate.now().plusDays(9),
            30
    );

    @Test
    public void whenAddAndGet() {
        Store store = new Shop();
        store.add(food);
        assertThat(store.get().get(0), is(food));
    }

    @Test
    public void whenDelete() {
        Store store = new Shop();
        store.add(food);
        store.delete();
        assertTrue(store.get().isEmpty());
    }
}