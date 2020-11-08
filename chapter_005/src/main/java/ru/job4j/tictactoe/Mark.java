package ru.job4j.tictactoe;

/**
 * Interface Mark
 * Интерфейс определяет вывод значения в игровое поле.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Mark<T> {
    /**
     * Метод отображает фишку на поле.
     * @param screen Объект для вывода значения фишки.
     */
    void print(T screen);
}
