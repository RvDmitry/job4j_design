package ru.job4j.multithreading.cas;

import java.util.Objects;

/**
 * Class Base
 * Класс описывает модель данных.
 * @author Dmitry Razumov
 * @version 1
 */
public class Base {
    /**
     * Идентификатор модели.
     */
    private final int id;
    /**
     * Версия модели.
     */
    private int version;
    /**
     * Наименование модели.
     */
    private String name;

    /**
     * Конструктор иницализирует модель.
     * @param id Идентификатор модели.
     * @param name Имя модели.
     */
    public Base(int id, int version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    /**
     * Метод возвращает идентификатор модели.
     * @return Идентификатор.
     */
    public int getId() {
        return id;
    }

    /**
     * Метод возвращает версию модели.
     * @return Версия.
     */
    public int getVersion() {
        return version;
    }

    /**
     * Метод задает версию модели.
     * @param version Версия.
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Метод возвращает наименование модели.
     * @return Наименование.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод задает наименование модели.
     * @param name Наименование.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод сравнивает две модели по идентификатору.
     * @param o Модель.
     * @return true, если модель таже самая, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return id == base.id;
    }

    /**
     * Метод вычисляет хеш-код модели по индетификатору.
     * @return Хеш-код.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
