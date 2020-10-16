package ru.job4j.design.lsp.strategy;

import ru.job4j.design.lsp.model.Food;
import ru.job4j.design.lsp.store.Warehouse;

import java.time.LocalDate;
import java.time.Period;

/**
 * Class WarehouseStrategy
 * Класс описывает стратегию отправки продуктов на склад.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class WarehouseStrategy implements FoodStrategy {
    /**
     * Метод принимает решение, применять ли данную стратегию к переданному продукту.
     * Стратегия отправляет продукты на склад, срок годности которых израсходован менее 25%.
     *
     * @param food Продукт.
     * @return True, если стратегия была применена успешна. False, если стратегия не применима.
     */
    @Override
    public boolean accept(Food food) {
        int expiration = Period.between(food.getCreateDate(), food.getExpaireDate()).getDays();
        int now = Period.between(food.getCreateDate(), LocalDate.now()).getDays();
        double percent = now * 100.0 / expiration;
        if (percent < 25) {
            new Warehouse().add(food);
            return true;
        }
        return false;
    }
}
