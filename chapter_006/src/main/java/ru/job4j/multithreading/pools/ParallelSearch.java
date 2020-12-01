package ru.job4j.multithreading.pools;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Class ParallelSearch
 * Класс реализует параллельный поиск индекса в массиве объектов.
 * @author Dmitry Razumov
 * @version 1
 */
public class ParallelSearch<T> extends RecursiveTask<Integer> {
    /**
     * Массив, в котором ищется элемент.
     */
    private final T[] array;
    /**
     * Начальный индекс поиска элемента.
     */
    private final int from;
    /**
     * Конечный индекс поиска элемента.
     */
    private final int to;
    /**
     * Элемент, который нужно найти.
     */
    private final T find;

    /**
     * Контсруктор инициализирует параметры класса.
     * @param array Массив, в котором ищется элемент.
     * @param from Начальный индекс поиска.
     * @param to Конечный индекс поиска.
     * @param find Искомый элемент.
     */
    public ParallelSearch(T[] array, int from, int to, T find) {
        this.array = array;
        this.from = from;
        this.to = to;
        this.find = find;
    }

    /**
     * Метод осуществляет поиск элемента в массиве.
     * @return Индекс найденного элемента, иначе -1.
     */
    @Override
    protected Integer compute() {
        if (to - from <= 10) {
            for (int i = from; i <= to; i++) {
                if (array[i].equals(find)) {
                    return i;
                }
            }
            return -1;
        }
        int mid = (from + to) / 2;
        ParallelSearch<T> leftSort = new ParallelSearch<>(array, from, mid, find);
        ParallelSearch<T> rightSort = new ParallelSearch<>(array, mid + 1, to, find);
        leftSort.fork();
        rightSort.fork();
        int left = leftSort.join();
        int right = rightSort.join();
        return left != -1 ? left : right;
    }

    /**
     * Метод осуществляет поиск заданного элемента в массиве объектов.
     * @param array Массив в котором ищется элемент.
     * @param find Элемент поиска.
     * @return Индекс найденного элемента в массиве, если элемента нет, то -1
     */
    public static <V> Integer search(V[] array, V find) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(new ParallelSearch<>(array, 0, array.length - 1, find));
    }
}
