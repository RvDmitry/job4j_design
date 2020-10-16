package ru.job4j.design.lsp;

import ru.job4j.design.lsp.model.Food;
import ru.job4j.design.lsp.strategy.FoodStrategy;

import java.util.List;

/**
 * Class ControllQuality
 * Класс распределяет продукты по местам хранения либо утилизирует их,
 * в зависимости от условий передаваемых в класс стратегий.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class ControllQuality {
    /**
     * Список стратегий.
     */
    private final List<FoodStrategy> strategies;

    /**
     * Конструктор инициализирует список стратегий.
     * @param strategies Список стратегий.
     */
    public ControllQuality(List<FoodStrategy> strategies) {
        this.strategies = strategies;
    }

    /**
     * Метод осуществляет распределения продуктов по местам хранения либо утилизирует.
     * @param foods Список продуктов.
     */
    public void sort(List<Food> foods) {
        for (Food food : foods) {
            for (var st : strategies) {
                if (st.accept(food)) {
                    break;
                }
            }
        }
    }
}
