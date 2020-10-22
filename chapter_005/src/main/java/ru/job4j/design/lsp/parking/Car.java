package ru.job4j.design.lsp.parking;

import java.util.Objects;

/**
 * Class Car
 * Класс описывает автомобили.
 * @author Dmitry Razumov
 * @version 1
 */
public class Car  {
    /**
     * Номер машины.
     */
    private final String id;
    /**
     * Размерность машины. Определяет, является ли машина легковой для n = 1 или грузовой для n > 1.
     */
    private final int n;

    /**
     * Конструктор инициализирует автомобиль.
     * @param id Номер машины.
     * @param n Размерность машины.
     */
    public Car(String id, int n) {
        this.id = id;
        this.n = n;
    }

    /**
     * Метод возвращает номер машины.
     * @return Номер машины.
     */
    public String getId() {
        return id;
    }

    /**
     * Метод возвращает размерность машины.
     * @return Размерность машины.
     */
    public int getN() {
        return n;
    }

    /**
     * Метод сравнивает два автомобиля и определяет, один и тот же это автомобиль или разные машины.
     * @param o Автомобиль.
     * @return true, если автомобиль один и тот же, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    /**
     * Метод возвращает хеш-код машины.
     * @return Хеш-код.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
