package ru.job4j.gc;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class PrintFileActionTest
 * Класс тестирует работу класса PrintFileAction.
 * С помощью вспомогательного класса StubInput иммитируется ввод данных пользователем в консоле.
 * @author Dmitry Razumov
 * @version 1
 */
public class PrintFileActionTest {
    /**
     * Метод тестирует обращение в кешу.
     * В кеш заранее записываются данные, которые потом будут вычитаны из кеша.
     * При запросе метод возвращает данные содержащиеся в кеше.
     */
    @Test
    public void whenCacheContainsFile() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String name = "FileName";
        String text = "Эта информация содержится в файле";
        SoftCache cache = new SoftCache(null);
        cache.put(name, text);
        Input input = new StubInput(new String[] {name});
        PrintFileAction printFile = new PrintFileAction();
        printFile.execute(input, cache);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Содержимое файла:")
                .add(text)
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(stdout);
    }
}