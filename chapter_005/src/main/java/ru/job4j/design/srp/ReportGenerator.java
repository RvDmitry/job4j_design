package ru.job4j.design.srp;

import java.util.List;

/**
 * Interface ReportGenerator
 * Интерфейс определяет генерацию отчетов.
 * @author Dmitry Razumov
 * @version 1
 */
public interface ReportGenerator {
    /**
     * Метод возвращает отчет о сотрудниках компании в виде строки.
     * @param employees Список сотрудников.
     * @return Строка
     */
    String generate(List<Employee> employees);
}
