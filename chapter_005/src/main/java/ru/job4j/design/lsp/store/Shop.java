package ru.job4j.design.lsp.store;

import ru.job4j.design.lsp.model.Food;

import java.time.LocalDate;
import java.time.Period;
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

    /**
     * Метод принимает решение, отправлять ли переданный продукт в магазин.
     * Продукт отправляется в магазин, если срок годности его израсходован от 25% до 75%.
     * А также, если срок годности его больше 75% и не превышает 100%,
     * но при этом для продукта устанавливается заданная скидка.
     * @param food Продукт.
     * @return true, если продукт нужно отправить, иначе false.
     */
    @Override
    public boolean accept(Food food) {
        int expiration = Period.between(food.getCreateDate(), food.getExpaireDate()).getDays();
        int now = Period.between(food.getCreateDate(), LocalDate.now()).getDays();
        double percent = now * 100.0 / expiration;
        if (percent >= 25 && percent <= 75) {
            foods.add(food);
            return true;
        }
        if (percent > 75 && percent <= 100) {
            food.setDisscount(10);
            foods.add(food);
            return true;
        }
        return false;
    }
}
