package ru.job4j.design.lsp.storage.store;

import ru.job4j.design.lsp.storage.model.Food;

import java.time.LocalDate;
import java.time.Period;
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

    /**
     * Метод принимает решение, отправлять ли переданный продукт в мусорку.
     * Продукт отправляется в мусорку, если срок годности его истек.
     * @param food Продукт.
     * @return true, если продукт нужно отправить, иначе false.
     */
    @Override
    public boolean accept(Food food) {
        int expiration = Period.between(food.getCreateDate(), food.getExpaireDate()).getDays();
        int now = Period.between(food.getCreateDate(), LocalDate.now()).getDays();
        double percent = now * 100.0 / expiration;
        if (percent > 100) {
            foods.add(food);
            return true;
        }
        return false;
    }
}
