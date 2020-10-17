package ru.job4j.design.lsp.storage;

import ru.job4j.design.lsp.storage.model.Food;
import ru.job4j.design.lsp.storage.store.Store;

import java.util.List;

/**
 * Class ControllQuality
 * Класс распределяет продукты по местам хранения либо утилизирует их.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class ControllQuality {
    /**
     * Список хранилищ.
     */
    private final List<Store> stores;

    /**
     * Конструктор инициализирует список хранилищ.
     * @param stores Список хранилищ.
     */
    public ControllQuality(List<Store> stores) {
        this.stores = stores;
    }

    /**
     * Метод осуществляет распределения продуктов по местам хранения либо утилизирует.
     * @param foods Список продуктов.
     */
    public void sort(List<Food> foods) {
        for (Food food : foods) {
            for (var st : stores) {
                if (st.accept(food)) {
                    break;
                }
            }
        }
    }
}
