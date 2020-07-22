package ru.job4j.collection;

import java.util.*;

/**
 * Class FreezeStr
 * Класс проверяет, получена ли строка путем перестановки символов исходной строки.
 * @author Dmitry Razumov
 * @version 1
 */
public class FreezeStr {
    /**
     * Метод проверят совпадают ли символы в двух строках.
     * @param left Первая строка
     * @param right Вторая строка
     * @return true, если символы в строках совпадают, иначе false
     */
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        for (int i = 0; i < leftArray.length; i++) {
            int val = map.computeIfAbsent(leftArray[i], character -> 0);
            val++;
            putRemoveMapValue(leftArray[i], val, map);

            val = map.computeIfAbsent(rightArray[i], character -> 0);
            val--;
            putRemoveMapValue(rightArray[i], val, map);
        }
        return map.size() == 0;
    }

    /**
     * Метод добавляет либо удаляет элемент из коллекции, в зависимости от значения.
     * @param ch Ключ
     * @param val Значение
     * @param map Коллекция
     */
    private static void putRemoveMapValue(char ch, int val, Map<Character, Integer> map) {
        if (val == 0) {
            map.remove(ch);
        } else {
            map.put(ch, val);
        }
    }
}
