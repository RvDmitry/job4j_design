package ru.job4j.design.lsp.strategy;

import ru.job4j.design.lsp.model.Food;
import ru.job4j.design.lsp.store.Shop;

import java.time.LocalDate;
import java.time.Period;

/**
 * Class ShopStrategy
 * Класс описывает стратегию помещения продуктов в магазин.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class ShopStrategy implements FoodStrategy {
    /**
     * Метод принимает решение, применять ли данную стратегию к переданному продукту.
     * Стратегия отправляет продукты в магазин, срок годности которых израсходован от 25% до 75%.
     *
     * @param food Продукт.
     * @return True, если стратегия была применена успешна. False, если стратегия не применима.
     */
    @Override
    public boolean accept(Food food) {
        int expiration = Period.between(food.getCreateDate(), food.getExpaireDate()).getDays();
        int now = Period.between(food.getCreateDate(), LocalDate.now()).getDays();
        double percent = now * 100.0 / expiration;
        if (percent >= 25 && percent <= 75) {
            new Shop().add(food);
            return true;
        }
        return false;
    }
}
