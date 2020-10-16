package ru.job4j.design.lsp.strategy;

import org.junit.Test;
import ru.job4j.design.lsp.model.Bakery;
import ru.job4j.design.lsp.model.Food;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Class ShopStrategyTest
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class ShopStrategyTest {

    @Test
    public void whenTrue() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(10),
                30
        );
        FoodStrategy strategy = new ShopStrategy();
        assertTrue(strategy.accept(food));
    }

    @Test
    public void whenFalse() {
        Food food = new Bakery(
                "Хлеб",
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(10),
                30
        );
        FoodStrategy strategy = new ShopStrategy();
        assertFalse(strategy.accept(food));
    }
}