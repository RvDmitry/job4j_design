package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class ConfigTest
 * Класс тестирует чтение файла конфигурации.
 * @author Dmitry Razumov
 * @version 1
 */
public class ConfigTest {

    @Test
    public void whenLoadAndGetValue() {
        Config config = new Config("./src/main/resources/app.properties");
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }
}