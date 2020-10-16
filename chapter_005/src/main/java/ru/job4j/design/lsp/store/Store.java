package ru.job4j.design.lsp.store;

import ru.job4j.design.lsp.model.Food;

import java.util.List;

/**
 * interface Store
 * Интерфейс характеризует хранилища для продуктов.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public interface Store {
    /**
     * Метод помещает продукт в хранилище.
     * @param food Продукт.
     */
    void add(Food food);

    /**
     * Метод возвращает список продуктов содержащихся в хранилище.
     * @return Список продуктов.
     */
    List<Food> get();

    /**
     * Метод удаляет продукты из хранилища.
     */
    void delete();
}
