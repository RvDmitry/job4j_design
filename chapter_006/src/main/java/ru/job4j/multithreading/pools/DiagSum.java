package ru.job4j.multithreading.pools;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Class DiagSum
 * Класс вычисляет суммы элементов по диагоналям матрицы.
 * @author Dmitry Razumov
 * @version 1
 */
public class DiagSum {
    /**
     * Метод асинхронно вычисляет сумму всех диагоналей матрицы.
     * И результат возвращает ввиде массива сумм.
     * @param matrix Матрица.
     * @return Массив сумм диагоналей.
     * @throws ExecutionException Исключение.
     * @throws InterruptedException Исключение.
     */
    public static int[] asyncSum(int[][] matrix) throws ExecutionException, InterruptedException {
        int n = matrix.length;
        int[] sums = new int[2 * n];
        Map<Integer, CompletableFuture<Integer>> futures = new HashMap<>();
        futures.put(0, getTask(matrix, 0, n - 1, n - 1));
        for (int k = 1; k <= n; k++) {
            futures.put(k, getTask(matrix, 0, k - 1,  k - 1));
            if (k < n) {
                futures.put(2 * n - k, getTask(matrix, n - k, n - 1, n - 1));
            }
        }
        for (Integer key : futures.keySet()) {
            sums[key] = futures.get(key).get();
        }
        return sums;
    }

    /**
     * Метод вычисляет сумму чисел на заданной диагонали матрицы.
     * @param data Матрица.
     * @param startRow Строка, на которой начинается диагональ.
     * @param endRow  Строка, на которой заканчивается диагональ.
     * @param startCol Столбец, на котором начинается диагональ.
     * @return Объект, который содержит сумму чисел на диагонали.
     */
    public static CompletableFuture<Integer> getTask(int[][] data, int startRow,
                                                     int endRow, int startCol) {
        return CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            int col = startCol;
            for (int i = startRow; i <= endRow; i++) {
                sum += data[i][col];
                col--;
            }
            return sum;
        });
    }
}
