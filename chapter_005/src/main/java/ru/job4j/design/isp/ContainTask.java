package ru.job4j.design.isp;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ContainTask
 * Класс характеризует пункт меню, в который вложены другие пункты.
 * @author Dmitry Razumov
 * @version 1
 */
public class ContainTask implements Item, MultiItem {
    /**
     * Наименование пункта меню.
     */
    private String name;
    /**
     * Список содержит пункты меню.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Конструктор иницализирует пункт меню.
     * @param name Ниманование пункта.
     */
    public ContainTask(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает наименование пункта меню.
     * @return Наименование пункта.
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Метод возвращает список пунктов меню, содержащихся в данном корневом пункте.
     * @return Список пунктов меню.
     */
    @Override
    public List<Item> get() {
        return items;
    }

    /**
     * Метод добавляет пункт меню в список.
     * @param item Пункт меню.
     */
    @Override
    public void add(Item item) {
        items.add(item);
    }
}
