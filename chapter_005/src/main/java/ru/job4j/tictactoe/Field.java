package ru.job4j.tictactoe;

/**
 * Interface Field
 * Интерфейс характеризует игровое поле.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Field {
    /**
     * Метод осуществляет вывод поля на экран.
     */
    void printField();

    /**
     * Метод проверяет, заполнено ли поле или нет.
     * @return true, если поле заполнено полностью, иначе false.
     */
    boolean isFieldFull();
}
