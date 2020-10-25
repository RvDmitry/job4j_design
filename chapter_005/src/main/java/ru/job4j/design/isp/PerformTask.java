package ru.job4j.design.isp;

/**
 * Class PerformTask
 * Класс описывает пункт меню, при выборе которого будет выполнено заданное действие.
 * @author Dmitry Razumov
 * @version 1
 */
public class PerformTask implements Item, ActionItem {
    /**
     * Наименование пункта меню.
     */
    private String name;

    /**
     * Конструктор инициализирует пункт меню.
     * @param name Наименование пункта меню.
     */
    public PerformTask(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает наименование пункта меню.
     * @return Наименование пункта меню.
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Метод выполняет заданное действие при выборе данного пункта меню.
     * @return true, если действие выполнено успешно, иначе false.
     */
    @Override
    public boolean execute() {
        System.out.println("-------------------");
        System.out.println("Выполнена " + name);
        System.out.println("-------------------");
        return true;
    }
}
