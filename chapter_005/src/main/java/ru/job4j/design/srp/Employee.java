package ru.job4j.design.srp;

import java.util.Calendar;
import java.util.Objects;

/**
 * Class Employee
 * Класс описывает сотрудников компании.
 * @author Dmitry Razumov
 * @version 1
 */
public class Employee {
    /**
     * Имя сотрудника.
     */
    private String name;
    /**
     * Дата приема на работу.
     */
    private Calendar hired;
    /**
     * Дата увольнения.
     */
    private Calendar fired;
    /**
     * Заработная плата.
     */
    private double salary;

    /**
     * Конструктор инициализирует сотрудника компании.
     * @param name Имя.
     * @param hired Дата приема на работу.
     * @param fired Дата увольнения.
     * @param salary Заработная плата.
     */
    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    /**
     * Метод возвращает имя сотрудника.
     * @return Имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод задает имя сотрудника.
     * @param name Имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает дату приема сотрудника на работу.
     * @return Дата приема на работу.
     */
    public Calendar getHired() {
        return hired;
    }

    /**
     * Метод устанавливает дату приема на работу.
     * @param hired Дата приема.
     */
    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    /**
     * Метод возвращает дату увольнения.
     * @return Дата увольнения.
     */
    public Calendar getFired() {
        return fired;
    }

    /**
     * Метод задает дату увольнения.
     * @param fired Дата увольнения.
     */
    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    /**
     * Метод возвращает заработную плату.
     * @return Заработная плата.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Метод устанавливает заработную плату.
     * @param salary Заработная плата.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Метод сравнивает сотрудников по имени.
     * @param o Сотрудник.
     * @return true, если сотрудник тот же самый, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employer = (Employee) o;
        return Objects.equals(name, employer.name);
    }

    /**
     * Метод вычисляет хеш-код сотрудника по его имени.
     * @return Хеш-код.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
