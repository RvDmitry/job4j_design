package ru.job4j.design.lsp.strategy;

import ru.job4j.design.lsp.model.Food;

/**
 * Interface FoodStrategy
 * Интерфейс определяет стратегию для сортировки продуктов.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public interface FoodStrategy {
    /**
     * Метод принимает решение, применять ли данную стратегию к переданному продукту.
     * @param food Продукт
     * @return True, если стратегия была применена успешна. False, если стратегия не применима.
     */
    boolean accept(Food food);
}
