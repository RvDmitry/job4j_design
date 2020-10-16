package ru.job4j.design.lsp.strategy;

import ru.job4j.design.lsp.model.Food;
import ru.job4j.design.lsp.store.Trash;

import java.time.LocalDate;
import java.time.Period;

/**
 * Class TrashStrategy
 * Класс описывает стратегию отправки продуктов с истекшим сроком годности в мусорку.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class TrashStrategy implements FoodStrategy {
    /**
     * Метод принимает решение, применять ли данную стратегию к переданному продукту.
     * Стратегия отправляет продукты в мусорку, срок годности которых истек.
     *
     * @param food Продукт
     * @return True, если стратегия была применена успешна. False, если стратегия не применима.
     */
    @Override
    public boolean accept(Food food) {
        int expiration = Period.between(food.getCreateDate(), food.getExpaireDate()).getDays();
        int now = Period.between(food.getCreateDate(), LocalDate.now()).getDays();
        double percent = now * 100.0 / expiration;
        if (percent > 100) {
            new Trash().add(food);
            return true;
        }
        return false;
    }
}
