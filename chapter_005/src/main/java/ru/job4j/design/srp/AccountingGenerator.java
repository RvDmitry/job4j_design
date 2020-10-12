package ru.job4j.design.srp;

import java.util.List;

/**
 * Class AccountingGenerator
 * Класс создает отчет с данными о сотрудниках для отдела бухгалтерии.
 * @author Dmitry Razumov
 * @version 1
 */
public class AccountingGenerator implements ReportGenerator {
    /**
     * Метод возвращает отчет в виде строки текста c измененной зарплатой сотрудников.
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
                    .append(employee.getSalary() * 1.13).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
