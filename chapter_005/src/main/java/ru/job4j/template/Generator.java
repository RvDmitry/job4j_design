package ru.job4j.template;

import java.util.Map;

/**
 * Interface Generator
 * Интерфейс описывает шаблонизатор.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Generator {
    String produce(String template, Map<String, String> args);
}
