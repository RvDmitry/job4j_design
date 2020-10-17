package ru.job4j.design.lsp.store;

import ru.job4j.design.lsp.model.Food;

import java.time.LocalDate;
import java.time.Period;
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

    /**
     * Метод принимает решение, отправлять ли переданный продукт на склад.
     * Продукт отправляются на склад, если срок годности его израсходован менее чем 25%.
     * @param food Продукт.
     * @return true, если продукт нужно отправить, иначе false.
     */
    @Override
    public boolean accept(Food food) {
        int expiration = Period.between(food.getCreateDate(), food.getExpaireDate()).getDays();
        int now = Period.between(food.getCreateDate(), LocalDate.now()).getDays();
        double percent = now * 100.0 / expiration;
        if (percent < 25) {
            foods.add(food);
            return true;
        }
        return false;
    }
}
