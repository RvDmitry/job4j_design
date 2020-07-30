package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class Abuse
 * Класс удаляет из файла запрещенные слова и результат записывает в новый файл.
 * @author Dmitry Razumov
 * @version 1
 */
public class Abuse {
    /**
     * Метод удаляет из файла запрещенные слова и результат записывает в новый файл.
     * @param source Исходный файл
     * @param target Файл содержащий отфильтрованные слова
     * @param words Список содаржащий запрещенные слова
     * @throws IOException Исключение, возникающее при ошибке чтения либо записи файла
     */
    public static void drop(String source, String target, List<String> words) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(
                     new BufferedOutputStream(
                             new FileOutputStream(target)))) {
            in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !words.contains(word)).map(word -> word + " ")
                    .forEach(out::print);
        }
    }
}
