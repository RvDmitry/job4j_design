package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * Class ReportEngine
 * Класс осуществляет вывод отчета.
 * @author Dmitry Razumov
 * @version 1
 */
public class ReportEngine {
    /**
     * Поле содержит хранилище сотрудников.
     */
    private final Store store;

    /**
     * Конструктор инициализирует хранилище сотрудников.
     * @param store Ссылка на хранилище.
     */
    public ReportEngine(Store store) {
        this.store = store;
    }

    /**
     * Метод возвращает отчет о сотрудниках в виде строки.
     * @param report Объект типа ReportGenerator, определяет форму и вид отчета.
     * @param filter Условие согласно которому осуществляется поиск сотрудников в хранилище.
     * @return Отчет в виде строки.
     */
    public String generate(ReportGenerator report, Predicate<Employee> filter) {
        return report.generate(store.findBy(filter));
    }
}
