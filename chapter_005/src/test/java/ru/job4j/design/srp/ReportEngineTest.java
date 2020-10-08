package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Class ReportEngineTest
 * Класс тестирует формирование отчета сотрудников.
 * @author Dmitry Razumov
 * @version 1
 */
@Ignore
public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        List<Employee> employees = Arrays.asList(worker);
        ReportEngine engine = new ReportEngine(employees);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getHired()).append("; ")
                .append(worker.getFired()).append("; ")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.textGenerate(), is(expect.toString()));
    }

    @Test
    public void whenReportForProgrammers() {
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        List<Employee> employees = Arrays.asList(worker);
        ReportEngine engine = new ReportEngine(employees);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>").append(System.lineSeparator())
                .append("<html>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<p>Name; Hired; Fired; Salary;</p>").append(System.lineSeparator())
                .append("<p>")
                .append(worker.getName()).append("; ")
                .append(worker.getHired()).append("; ")
                .append(worker.getFired()).append("; ")
                .append(worker.getSalary()).append(";")
                .append("<p>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        assertThat(engine.htmlGenerate(), is(expect.toString()));
    }

    @Test
    public void whenReportForAccounting() {
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        List<Employee> employees = Arrays.asList(
                new Employee(
                        worker.getName(),
                        worker.getHired(),
                        worker.getFired(),
                        worker.getSalary() * 1.13
                ));
        ReportEngine engine = new ReportEngine(employees);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getHired()).append("; ")
                .append(worker.getFired()).append("; ")
                .append(worker.getSalary() * 1.13).append(";")
                .append(System.lineSeparator());
        assertThat(engine.textGenerate(), is(expect.toString()));
    }

    @Test
    public void whenReportForHR() {
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Worker1", now, now, 100);
        Employee worker2 = new Employee("Worker2", now, now, 200);
        List<Employee> employees = Arrays.asList(worker2, worker1);
        ReportEngine engine = new ReportEngine(employees);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append("; ")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append("; ")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.hrGenerate(), is(expect.toString()));
    }
}