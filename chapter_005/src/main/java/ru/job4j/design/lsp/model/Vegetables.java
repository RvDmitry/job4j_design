package ru.job4j.design.lsp.model;

import java.time.LocalDate;

/**
 * Class Vegetables
 * Класс характеризует овощи.
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class Vegetables extends Food {

    /**
     * Конструктор инициализирует характеристики продукта.
     *
     * @param name        Наименование.
     * @param createDate  Дата изготовления.
     * @param expaireDate Окончание срока годности.
     * @param price       Стоимость.
     */
    public Vegetables(String name, LocalDate createDate, LocalDate expaireDate, double price) {
        super(name, createDate, expaireDate, price);
    }
}
