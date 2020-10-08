package ru.job4j.design.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class MemStore
 * Класс реализует хранилище сотрудников компании.
 * @author Dmitry Razumov
 * @version 1
 */
public class MemStore implements Store {
    /**
     *  Поле содержит список сотрудников.
     */
    private final List<Employee> employees = new ArrayList<>();

    /**
     * Метод добавляет сотрудника в список.
     * @param em Сотрудник.
     */
    public void add(Employee em) {
        employees.add(em);
    }

    /**
     * Метод осуществялет поиск сотрудников согласно переданному условию.
     * @param filter Условие фильтрации.
     * @return Список сотрудников.
     */
    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }
}
