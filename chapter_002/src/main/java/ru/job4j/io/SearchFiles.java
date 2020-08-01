package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Class SearchFiles
 * Класс осуществляет поиск файлов удовлетворяющие заданному условию.
 * @author Dmitry Razumov
 * @version 1
 */
public class SearchFiles implements FileVisitor<Path> {
    /**
     * Условие, которому должны соответствовать файлы при поиске.
     */
    private final Predicate<Path> predicate;
    /**
     * Список содержащий файлы найденные при поиске.
     */
    private final List<Path> files = new ArrayList<>();

    /**
     * Конструктор задает условие поиска файлов.
     * @param predicate Условие
     */
    public SearchFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
            throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file)) {
            files.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    /**
     * Метод возвращает список найденных файлов.
     * @return Список файлов
     */
    public List<Path> getPaths() {
        return files;
    }
}
