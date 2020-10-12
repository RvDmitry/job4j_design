package ru.job4j.design.srp;

import java.util.List;
import java.util.StringJoiner;

/**
 * Class JsonGenerator
 * Класс создает отчет с данными о сотрудниках в формате JSON.
 * @author Dmitry Razumov
 * @version 1
 */
public class JsonGenerator implements ReportGenerator {
    /**
     * Метод возвращает отчет в формате JSON.
     * @param employees Список сотрудников.
     * @return Строка в формате JSON.
     */
    @Override
    public String generate(List<Employee> employees) {
        int size = employees.size();
        StringJoiner json = new StringJoiner(System.lineSeparator());
        json.add("{");
        json.add("  \"employees\": [");
        for (int i = 0; i < size; i++) {
            json.add("    {");
            json.add("      \"name\": " + '"' + employees.get(i).getName() + "\",");
            json.add("      \"hired\": " + employees.get(i).getHired() + ',');
            json.add("      \"fired\": " + employees.get(i).getFired() + ',');
            json.add("      \"salary\": " + employees.get(i).getSalary());
            if (i < size - 1) {
                json.add("    },");
            } else {
                json.add("    }");
            }
        }
        json.add("  ]");
        json.add("}");
        return json.toString();
    }
}
