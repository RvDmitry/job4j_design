package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Interface Store
 * Интерфейс описывает доступ к базе данных.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Store {
    /**
     * Метод возвращает список сотрудник согласно заданному фильтру.
     * @param filter Условие фильтрации.
     * @return Список сотрудников.
     */
    List<Employee> findBy(Predicate<Employee> filter);
}
