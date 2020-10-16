package ru.job4j.design.lsp.strategy;

import org.junit.Test;
import ru.job4j.design.lsp.model.Bakery;
import ru.job4j.design.lsp.model.Food;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Class TrashStrategyTest
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class TrashStrategyTest {

    @Test
    public void whenTrue() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(5),
                LocalDate.now().minusDays(1),
                30
        );
        FoodStrategy strategy = new TrashStrategy();
        assertTrue(strategy.accept(food));
    }

    @Test
    public void whenFalse() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(1),
                LocalDate.now(),
                30
        );
        FoodStrategy strategy = new TrashStrategy();
        assertFalse(strategy.accept(food));
    }
}