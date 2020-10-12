package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class HrGenerator
 * Класс создает отчет с данными о сотрудниках для отдела HR.
 * @author Dmitry Razumov
 * @version 1
 */
public class HrGenerator implements ReportGenerator {
    /**
     * Метод возвращает отчет в виде строки текста
     * только с некоторыми полями и сортировкой по убыванию.
     * @param employees Список сотрудников.
     * @return Строка с данными.
     */
    @Override
    public String generate(List<Employee> employees) {
        Comparator<Employee> comp = (o1, o2) -> {
            double diff = o2.getSalary() - o1.getSalary();
            return diff > 0 ? 1 : (diff < 0 ? -1 : 0);
        };
        List<Employee> sorted = employees.stream().sorted(comp).collect(Collectors.toList());
        StringBuilder text = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : sorted) {
            text.append(employee.getName()).append("; ")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
