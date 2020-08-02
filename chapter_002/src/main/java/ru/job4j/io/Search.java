package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Class Search
 * Класс выводит содержимое в заданной директории.
 * @author Dmitry Razumov
 * @version 1
 */
public class Search {
    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     * @throws IOException Исключение, если происходит ошибка чтения файла или каталога
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Root folder is null. "
                    + "Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Path start = Paths.get(args[0]);
        String exp = args[1];
        search(start, exp).forEach(System.out::println);
    }

    /**
     * Метод осуществляет поиск файлов с заданным расширением.
     * @param root Директория с которой нужно начать поиск
     * @param ext Расширение файлов, которые нужно найти
     * @return Список файлов с заданным расширением
     * @throws IOException Исключение, если происходит ошибка чтения файла или каталога
     */
    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
