package ru.job4j.design.lsp.strategy;

import org.junit.Test;
import ru.job4j.design.lsp.model.Bakery;
import ru.job4j.design.lsp.model.Food;

import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class DisscountStrategyTest
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class DisscountStrategyTest {

    @Test
    public void whenTrue() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(1),
                30
        );
        FoodStrategy strategy = new DisscountStrategy();
        assertTrue(strategy.accept(food));
    }

    @Test
    public void whenDisscount() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(1),
                30
        );
        FoodStrategy strategy = new DisscountStrategy();
        strategy.accept(food);
        assertThat(food.getDisscount(), is(10.0));
    }

    @Test
    public void whenFalse() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(5),
                30
        );
        FoodStrategy strategy = new DisscountStrategy();
        assertFalse(strategy.accept(food));
    }
}