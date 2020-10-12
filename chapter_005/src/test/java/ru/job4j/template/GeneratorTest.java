package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class GeneratorTest
 * Класс тестирует работу генератора шаблонов.
 * @author Dmitry Razumov
 * @version 1
 */
@Ignore
public class GeneratorTest {
    /**
     * Тест проверяет, возвращает ли метод строку по заданному шаблому.
     */
    @Test
    public void produce() {
        Generator generator = new GeneratorApp();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String expected = "I am a Petr Arsentev, Who are you? ";
        assertThat(expected, is(generator.produce(template, args)));
    }

    /**
     * Тест проверяет, выбрасывает ли метод исключение, при отсутствии необходимого ключа в карте.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenMapKeyIsMissing() {
        Generator generator = new GeneratorApp();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        generator.produce(template, args);
    }

    /**
     * Тест проверяет, выбрасывает ли метод исключение, когда в карте имеется лишний ключ.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenMapHasExtraKey() {
        Generator generator = new GeneratorApp();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("age", "35");
        generator.produce(template, args);
    }
}