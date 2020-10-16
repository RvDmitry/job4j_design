package ru.job4j.design.lsp.store;

import ru.job4j.design.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Warehouse
 * Класс характеризует склад продуктов.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class Warehouse implements Store {
    /**
     * Поле содержит хранилище для продуктов.
     */
    private static List<Food> foods = new ArrayList<>();

    /**
     * Метод помещает продукт на склад.
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
     * Метод удаляет продукты со склада.
     */
    @Override
    public void delete() {
        foods.clear();
    }
}
