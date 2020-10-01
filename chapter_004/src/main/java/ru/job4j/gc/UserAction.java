package ru.job4j.gc;

/**
 * Interface UserAction
 * Интерфейс определяет вывод пункта меню и действие при выборе данного пункта.
 * @author Dmitry Razumov
 * @version 1
 */
public interface UserAction {
    /**
     * Метод определяет наименование пункта меню.
     * @return Наименование пункта меню
     */
    String name();

    /**
     * Метод определяет действие, которое нужно выполнить в соответствии с выбранным пунктом меню.
     * @param input Объект для считывания ответов пользователя
     * @param cache Объект кеш
     * @return true, если операция выполнена успешно, иначе false
     */
    boolean execute(Input input, SoftCache cache);
}
