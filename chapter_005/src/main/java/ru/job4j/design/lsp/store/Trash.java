package ru.job4j.design.lsp.store;

import ru.job4j.design.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Trash
 * Класс хаарктеризует мусорку для продуктов.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class Trash implements Store {
    /**
     * Поле содержит хранилище для продуктов.
     */
    private static List<Food> foods = new ArrayList<>();

    /**
     * Метод помещает продукт в мусорку.
     * @param food Продукт.
     */
    @Override
    public void add(Food food) {
        foods.add(food);
    }

    /**
     * Метод возвращает список выброшенных продуктов.
     * @return Список продуктов.
     */
    @Override
    public List<Food> get() {
        return foods;
    }

    /**
     * Метод очищает мусорку.
     */
    @Override
    public void delete() {
        foods.clear();
    }
}
