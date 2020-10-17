package ru.job4j.design.lsp.storage.model;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class BakeryTest
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class BakeryTest {

    private final Food food = new Bakery(
            "Хлеб",
            LocalDate.now().minusDays(1),
            LocalDate.now().plusDays(1),
            30
    );

    @Test
    public void whenDisscount() {
        food.setDisscount(10);
        assertThat(food.getDisscount(), is(10.0));
    }

    @Test
    public void getName() {
        assertThat(food.getName(), is("Хлеб"));
    }

    @Test
    public void getCreateDate() {
        assertThat(food.getCreateDate(), is(LocalDate.now().minusDays(1)));
    }

    @Test
    public void getExpaireDate() {
        assertThat(food.getExpaireDate(), is(LocalDate.now().plusDays(1)));
    }

    @Test
    public void getPrice() {
        assertThat(food.getPrice(), is(30.0));
    }
}