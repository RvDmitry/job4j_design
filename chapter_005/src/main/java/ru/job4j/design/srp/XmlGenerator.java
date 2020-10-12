package ru.job4j.design.srp;

import java.util.List;
import java.util.StringJoiner;

/**
 * Class XmlGenerator
 * Класс создает отчет с данными о сотрудниках в формате XML.
 * @author Dmitry Razumov
 * @version 1
 */
public class XmlGenerator implements ReportGenerator {
    /**
     * Метод возвращает отчет в формате XML.
     * @param employees Список сотрудников.
     * @return Строка в формате XML.
     */
    @Override
    public String generate(List<Employee> employees) {
        StringJoiner xml = new StringJoiner(System.lineSeparator());
        xml.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.add("<employees>");
        for (Employee em : employees) {
            xml.add("  <employee>");
            xml.add("    <name>" + em.getName() + "</name>");
            xml.add("    <hired>" + em.getHired() + "</hired>");
            xml.add("    <fired>" + em.getFired() + "</fired>");
            xml.add("    <salary>" + em.getSalary() + "</salary>");
            xml.add("  </employee>");
        }
        xml.add("</employees>");
        return xml.toString();
    }
}
