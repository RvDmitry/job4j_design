package ru.job4j.design.lsp.storage.model;

import java.time.LocalDate;

/**
 * Class Fruit
 * Класс характеризует фрукты.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class Fruit extends Food {

    /**
     * Конструктор инициализирует характеристики продукта.
     *
     * @param name        Наименование.
     * @param createDate  Дата изготовления.
     * @param expaireDate Окончание срока годности.
     * @param price       Стоимость.
     */
    public Fruit(String name, LocalDate createDate, LocalDate expaireDate, double price) {
        super(name, createDate, expaireDate, price);
    }
}
