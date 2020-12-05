package ru.job4j.multithreading.pools;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Class RolColSum
 * Класс вычисляет суммы элементов матрицы по строкам и столбцам.
 * @author Dmitry Razumov
 * @version 1
 */
public class RolColSum {
    /**
     * Класс содержит сумму чисел матрицы по строке и по столбцу.
     */
    public static class Sums {
        /**
         * Сумма чисел строки.
         */
        private int rowSum;
        /**
         * Сумма чисел столбца.
         */
        private int colSum;

        public int getRowSum() {
            return rowSum;
        }

        public void setRowSum(int rowSum) {
            this.rowSum = rowSum;
        }

        public int getColSum() {
            return colSum;
        }

        public void setColSum(int colSum) {
            this.colSum = colSum;
        }
    }

    /**
     * Метод вычисляет суммму чисел матрицы по строкам и столбцам.
     * @param matrix Матрица.
     * @return Массив объектов, где каждый объект содержит сумму чисел строки и столбца.
     */
    public static Sums[] sum(int[][] matrix) {
        int n = matrix.length;
        Sums[] sums = new Sums[n];
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            Sums s = new Sums();
            s.setRowSum(rowSum);
            s.setColSum(colSum);
            sums[i] = s;
        }
        return sums;
    }

    /**
     * Метод асинхронно вычисляет сумму чисел по строкам и столбцам матрицы.
     * @param matrix Матрица.
     * @return Массив объектов, в которых содержится сумма строки и столбца.
     * @throws ExecutionException Исключение.
     * @throws InterruptedException Исключение.
     */
    public static Sums[] asyncSum(int[][] matrix) throws ExecutionException, InterruptedException {
        int n = matrix.length;
        Sums[] sums = new Sums[n];
        CompletableFuture<?>[] futures = new CompletableFuture<?>[n];
        for (int i = 0; i < n; i++) {
            futures[i] = getTask(matrix, i);
        }
        for (int i = 0; i < n; i++) {
            sums[i] = (Sums) futures[i].get();
        }
        return sums;
    }

    /**
     * Метод вычисляет сумму чисел в заданной строке и столбце.
     * @param matrix Матрица.
     * @param i Номер столбца и строки.
     * @return Объект содержищий сумму чисел строки и столбца.
     */
    public static CompletableFuture<Sums> getTask(int[][] matrix, int i) {
        return CompletableFuture.supplyAsync(() -> {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < matrix.length; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            Sums s = new Sums();
            s.setRowSum(rowSum);
            s.setColSum(colSum);
            return s;
        });
    }
}
