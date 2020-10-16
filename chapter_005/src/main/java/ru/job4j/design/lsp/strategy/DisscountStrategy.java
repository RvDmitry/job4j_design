package ru.job4j.design.lsp.strategy;

import ru.job4j.design.lsp.model.Food;
import ru.job4j.design.lsp.store.Shop;

import java.time.LocalDate;
import java.time.Period;

/**
 * Class DisscountStrategy
 * Класс описывает стратегию предоставления скидки на продукт и отправки его в магазин.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class DisscountStrategy implements FoodStrategy {
    /**
     * Метод принимает решение, применять ли данную стратегию к переданному продукту.
     * Стратегия устанавливат скидку на продукт, срок годности которых израсходован более 75%.
     * Затем отправляет продукт в магазин.
     *
     * @param food Продукт
     * @return True, если стратегия была применена успешна. False, если стратегия не применима.
     */
    @Override
    public boolean accept(Food food) {
        int expiration = Period.between(food.getCreateDate(), food.getExpaireDate()).getDays();
        int now = Period.between(food.getCreateDate(), LocalDate.now()).getDays();
        double percent = now * 100.0 / expiration;
        if (percent > 75 && percent <= 100) {
            food.setDisscount(10);
            new Shop().add(food);
            return true;
        }
        return false;
    }
}
