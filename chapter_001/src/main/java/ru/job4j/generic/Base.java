package ru.job4j.generic;

/**
 * Class Base
 *
 * @author Dmitry Razumov
 * @version 1
 */
public abstract class Base {
    /**
     * Идентификационный номер объекта.
     */
    private final String id;

    /**
     * Конструктор создает объект с заданным id.
     *
     * @param id Идентификационный номер объекта
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * Метод возвращает id объета.
     *
     * @return Идентификационный номер объекта
     */
    public String getId() {
        return id;
    }
}
