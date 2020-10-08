package ru.job4j.design.srp;

import java.util.List;

/**
 * Class ReportEngine
 * Класс осуществляет вывод отчета.
 * @author Dmitry Razumov
 * @version 1
 */
public class ReportEngine {
    /**
     * Поле содержит список сотрудников.
     */
    private List<Employee> employees;

    /**
     * Конструктор инициализирует список сотрудников.
     * @param employees Список сотрудников.
     */
    public ReportEngine(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Метод создает отчет с данными о сотрудниках в виде строки текста.
     * @return Строка с данными.
     */
    public String textGenerate() {
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

    /**
     * Метод создает отчет с данными о сотрудниках в виде текста в формате HTML.
     * @return Строка в формате HTML.
     */
    public String htmlGenerate() {
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

    /**
     * Метод создает неполный отчет о сотрудниках в виде строки текста.
     * @return Строка с данными.
     */
    public String hrGenerate() {
        StringBuilder text = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append("; ")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
