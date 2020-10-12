package ru.job4j.design.srp;

import java.util.List;

/**
 * Class TextGenerator
 * Класс создает отчет с данными о сотрудниках в виде текстовой строки.
 * @author Dmitry Razumov
 * @version 1
 */
public class TextGenerator implements ReportGenerator {
    /**
     * Метод возвращает отчет в виде строки текста.
     * @param employees Список сотрудников.
     * @return Строка с данными.
     */
    @Override
    public String generate(List<Employee> employees) {
        StringBuilder text = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append("; ")
                    .append(employee.getHired()).append("; ")
                    .append(employee.getFired()).append("; ")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
