package ru.job4j.design.srp;

import java.util.List;

/**
 * Class HtmlGenerator
 * Класс создает отчет с данными о сотрудниках в формате HTML.
 * @author Dmitry Razumov
 * @version 1
 */
public class HtmlGenerator implements ReportGenerator {
    /**
     * Метод возвращает отчет в формате HTML.
     * @param employees Список сотрудников.
     * @return Строка в формате HTML.
     */
    @Override
    public String generate(List<Employee> employees) {
        StringBuilder text = new StringBuilder()
                .append("<!DOCTYPE html>").append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<p>Name; Hired; Fired; Salary;</p>").append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append("<p>")
                    .append(employee.getName()).append("; ")
                    .append(employee.getHired()).append("; ")
                    .append(employee.getFired()).append("; ")
                    .append(employee.getSalary()).append(";")
                    .append("<p>").append(System.lineSeparator());
        }
        text.append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        return text.toString();
    }
}
