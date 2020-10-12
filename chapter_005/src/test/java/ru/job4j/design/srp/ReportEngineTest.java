package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.StringJoiner;

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
        ReportGenerator report = new TextGenerator();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getHired()).append("; ")
                .append(worker.getFired()).append("; ")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenHTMLReport() {
        ReportGenerator report = new HtmlGenerator();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
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
        assertThat(engine.generate(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportForAccounting() {
        ReportGenerator report = new AccountingGenerator();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getHired()).append("; ")
                .append(worker.getFired()).append("; ")
                .append(worker.getSalary() * 1.13).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportForHR() {
        ReportGenerator report = new HrGenerator();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Worker1", now, now, 100);
        Employee worker2 = new Employee("Worker2", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append("; ")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append("; ")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenXMLReport() {
        ReportGenerator report = new XmlGenerator();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringJoiner expect = new StringJoiner(System.lineSeparator());
        expect.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        expect.add("<employees>");
        expect.add("  <employee>");
        expect.add("    <name>" + worker.getName() + "</name>");
        expect.add("    <hired>" + worker.getHired() + "</hired>");
        expect.add("    <fired>" + worker.getFired() + "</fired>");
        expect.add("    <salary>" + worker.getSalary() + "</salary>");
        expect.add("  </employee>");
        expect.add("</employees>");
        assertThat(engine.generate(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenJSONReport() {
        ReportGenerator report = new JsonGenerator();
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringJoiner expect = new StringJoiner(System.lineSeparator());
        expect.add("{");
        expect.add("  \"employees\": [");
        expect.add("    {");
        expect.add("      \"name\": " + '"' + worker.getName() + "\",");
        expect.add("      \"hired\": " + worker.getHired() + ',');
        expect.add("      \"fired\": " + worker.getFired() + ',');
        expect.add("      \"salary\": " + worker.getSalary());
        expect.add("    }");
        expect.add("  ]");
        expect.add("}");
        assertThat(engine.generate(report, em -> true), is(expect.toString()));
    }
}