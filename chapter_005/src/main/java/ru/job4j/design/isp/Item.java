package ru.job4j.design.isp;

/**
 * Interface Item
 * Интерфейс определяет пункт меню.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Item {
    /**
     * Метод возвращает наименование пункта меню.
     * @return Наименование пункта меню.
     */
    String name();
}
