package ru.job4j.design.lsp.storage.store;

import ru.job4j.design.lsp.storage.model.Food;

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
     * Метод возвращает список продуктов содержащихся в хранилище.
     * @return Список продуктов.
     */
    List<Food> get();

    /**
     * Метод удаляет продукты из хранилища.
     */
    void delete();

    /**
     * Метод принимает решение, добавлять ли переданный продукт в выбранное хранилище.
     * @param food Продукт.
     * @return true, если продукт нужно добавить, иначе false.
     */
    boolean accept(Food food);
}
