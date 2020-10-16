package ru.job4j.design.lsp.model;

import java.time.LocalDate;

/**
 * Class Food
 * Класс характеризует продукты.
 * @author Dmitry Razumov
 * @version 1
 */
public abstract class Food {
    /**
     * Наименование продукта.
     */
     private String name;
    /**
     * Дата изготовления продукта.
     */
    private LocalDate createDate;
    /**
     * Дата окончания срока годности продукта.
     */
    private LocalDate expaireDate;
    /**
     * Стоимость продукта.
     */
    private double price;
    /**
     * Скидка на продукт.
     */
     private double disscount;

    /**
     * Конструктор инициализирует характеристики продукта.
     * @param name Наименование.
     * @param createDate Дата изготовления.
     * @param expaireDate Окончание срока годности.
     * @param price Стоимость.
     */
    public Food(String name, LocalDate createDate, LocalDate expaireDate, double price) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
    }

    /**
     * Метод задает скидку на продукт.
     * @param disscount Скидка.
     */
    public void setDisscount(double disscount) {
        this.disscount = disscount;
    }

    /**
     * Метод возвращает наименование продукта.
     * @return Наименование.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает дату изготовления продукта.
     * @return Дата изготовления.
     */
    public LocalDate getCreateDate() {
        return createDate;
    }

    /**
     * Метод возвращает дату окончания годности продукта.
     * @return Дата окончания годности.
     */
    public LocalDate getExpaireDate() {
        return expaireDate;
    }

    /**
     * Метод возвращает цену.
     * @return Цена.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Метод возвращает скидку.
     * @return Скидка.
     */
    public double getDisscount() {
        return disscount;
    }
}
