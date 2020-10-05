package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

/**
 * Class MaxMin
 * Класс осуществляет поиск минимального и максимального элемента в коллекции.
 * @author Dmitry Razumov
 * @version 1
 */
public class MaxMin {
    /**
     * Метод используя компаратор возвращает максимальный элемент списка.
     * @param value Список
     * @param comparator Компаратор
     * @param <T> Тип элемента списка
     * @return Максимальный элемент
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        if (value == null || value.size() == 0) {
            return null;
        }
        T max = value.get(0);
        for (T el : value) {
            if (comparator.compare(max, el) < 0) {
                max = el;
            }
        }
        return max;
    }

    /**
     * Метод используя компаратор возвращает минимальный элемент списка.
     * @param value Список
     * @param comparator Компаратор
     * @param <T> Тип элемента списка
     * @return Минимальный элемент
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        if (value == null || value.size() == 0) {
            return null;
        }
        T min = value.get(0);
        for (T el : value) {
            if (comparator.compare(min, el) > 0) {
                min = el;
            }
        }
        return min;
    }
}
