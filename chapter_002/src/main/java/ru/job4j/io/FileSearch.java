package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Class FileSearch
 * Класс осуществляет поиск файла либо по имени либо по маске.
 * @author Dmitry Razumov
 * @version 1
 */
public class FileSearch {

    /**
     * Метод осуществляет поиск файлов в заданной директории согласно переданному условию.
     * @param root Директория для поиска файлов
     * @param predicate Условие, по которому ищутся файлы
     * @return Список файлов находящихся в директории
     * @throws IOException Исключение, если происходит ошибка чтения файла или каталога
     */
    private List<Path> search(Path root, Predicate<Path> predicate) throws IOException {
        SearchFiles searcher = new SearchFiles(predicate);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    /**
     * Метод выполняет запись результата поиска в файл.
     * @param file Файл результата
     * @param log Список файлов для записи
     */
    private void output(String file, List<Path> log) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            log.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод вовзращает условие поиска файла в зависимости от заданного ключа поиска.
     * По умолчанию возвращается критерий для полного совпадения, если не задан другой ключ.
     * При наличии ключа поиска по маске либо по регулярному выражению, возвращается соответствующий
     * критерий поиска. Если маска задана через '*' в начале искомой подстроки, то ищются
     * файлы оканчивающиеся на заданную маску за исключением символа '*'.
     * Если '*' отсутствует, ищется любое содержание искомой подстроки в имени файла.
     * @param name Строка или подстрока, которая содержится в имени файла
     * @param type Критерий поиска, по маске, по регулярному выражению либо полное совпадение имени
     * @return Условие поиска файла
     */
    private Predicate<Path> condition(String name, String type) {
        Predicate<Path> predicate = path -> path.getFileName().toString().equals(name);
        if (type.equals("-m")) {
            if (name.charAt(0) == '*') {
                predicate = path -> path.getFileName().toString().endsWith(name.substring(1));
            } else {
                predicate = path -> path.getFileName().toString().contains(name);
            }
        }
        if (type.equals("-r")) {
            Pattern pattern = Pattern.compile(name);
            predicate = path -> pattern.matcher(path.getFileName().toString()).find();
        }
        return predicate;
    }

    /**
     * Главный метод программы. Запускает программу.
     * Осущевляет поиск файла в заданной директории по имени
     * либо по маске или регулярному выражению.
     * Результат сохраняет в заданный файл.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) throws IOException {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Количество заданных ключей неверное.");
        joiner.add("Проверьте наличие обязательных ключей:");
        joiner.add("-d \"директория поиска файла\"");
        joiner.add("-n \"имя файла поиска либо маска поиска либо регулярное выражение\"");
        joiner.add("-o \"имя файла для записи результата поиска\"");
        joiner.add("А также наличие одного из следующих ключей");
        joiner.add("-m \"искать по маске\"");
        joiner.add("-f \"искать по полному совпадению имени\"");
        joiner.add("-r \"искать по регулярному выражению\"");
        ArgSearch arg = new ArgSearch(args);
        if (!arg.valid()) {
            throw new IllegalArgumentException(joiner.toString());
        }
        FileSearch searcher = new FileSearch();
        Predicate<Path> predicate = searcher.condition(arg.name(), arg.type());
        List<Path> log = searcher.search(Paths.get(arg.directory()), predicate);
        searcher.output(arg.output(), log);
    }
}
