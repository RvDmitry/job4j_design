package ru.job4j.design.lsp.store;

import ru.job4j.design.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Shop
 * Класс характеризует магазин продуктов.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class Shop implements Store {
    /**
     * Поле содержит хранилище для продуктов.
     */
    private static List<Food> foods = new ArrayList<>();

    /**
     * Метод помещает продукт в магазин.
     * @param food Продукт.
     */
    @Override
    public void add(Food food) {
        foods.add(food);
    }

    /**
     * Метод возвращает список продуктов.
     * @return Список продуктов.
     */
    @Override
    public List<Food> get() {
        return foods;
    }

    /**
     * Метод удаляет продукты из магазина.
     */
    @Override
    public void delete() {
        foods.clear();
    }
}
