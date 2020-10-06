package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

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
     * @param <T> Тип элементов списка
     * @return Максимальный элемент
     */
    public <T> T max(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> biPre = (e1, e2) -> comparator.compare(e1, e2) < 0;
        return find(value, biPre);
    }

    /**
     * Метод используя компаратор возвращает минимальный элемент списка.
     * @param value Список
     * @param comparator Компаратор
     * @param <T> Тип элементов списка
     * @return Минимальный элемент
     */
    public <T> T min(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> biPre = (e1, e2) -> comparator.compare(e1, e2) > 0;
        return find(value, biPre);
    }

    /**
     * Метод находит элемент из переданного списка, согласно переданному условию.
     * @param value Список
     * @param biPre Условие поиска элемента
     * @param <T> Тип элементов списка
     * @return Найденный элемент списка согласно условию
     */
    private <T> T find(List<T> value, BiPredicate<T, T> biPre) {
        if (value == null || value.size() == 0) {
            return null;
        }
        T elem = value.get(0);
        for (T el : value) {
            if (biPre.test(elem, el)) {
                elem = el;
            }
        }
        return elem;
    }
}
