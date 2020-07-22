package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Class Article
 * Класс проверяет, был ли некоторый текст получен из другого текста.
 * @author Dmitry Razumov
 * @version 1
 */
public class Article {
    /**
     * Метод проверяет, был ли текст получен из другого текста.
     * @param origin Ориганальный текста
     * @param line Проверяемый текст
     * @return true, если текст сгенерирован из оригинального, иначе false
     */
    public static boolean generateBy(String origin, String line) {
        String[] text = origin.split("\\s*(\\s|,|!|;|:|\\.)\\s*");
        String[] str = line.split("\\s*(\\s|,|!|;|:|\\.)\\s*");
        Set<String> set = new HashSet<>();
        for (String s : text) {
            set.add(s);
        }
        for (String s : str) {
            if (!set.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
