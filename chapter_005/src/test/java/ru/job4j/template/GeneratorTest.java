package ru.job4j.template;

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
public class GeneratorTest {
    /**
     * Поле задает шаблон для теста.
     */
    private final String template = "I am a ${name}, Who are ${subject}? ";
    /**
     * Поле создает и инициализирует карту для теста.
     */
    private final Map<String, String> args = new HashMap<>();
    /**
     * Поле создает и инициализиоует объект-генератор для теста.
     */
    private final Generator generator = new GeneratorApp();

    /**
     * Тест проверяет, возвращает ли метод строку по заданному шаблому.
     */
    @Test
    public void produce() {
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
        args.put("name", "Petr Arsentev");
        generator.produce(template, args);
    }

    /**
     * Тест проверяет, выбрасывает ли метод исключение, когда в карте имеется лишний ключ.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenMapHasExtraKey() {
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("age", "35");
        generator.produce(template, args);
    }
}