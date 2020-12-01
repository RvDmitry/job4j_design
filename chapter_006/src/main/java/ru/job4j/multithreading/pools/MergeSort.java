package ru.job4j.multithreading.pools;

/**
 * Class MergeSort
 * Класс реализует рекурсивную сортировку слиянием.
 * @author Dmitry Razumov
 * @version 1
 */
public class MergeSort {
    /**
     * Метод осуществляет сортировку переданного массива.
     * @param array Массив, который нужно отсортировать.
     * @return Отсортированный массив.
     */
    public static int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    /**
     * Метод осуществляет сортировку с помощью рекурсивного вызова самого себя.
     * Метод разделяет полученный массив на два массива и
     * возвращает объединенный отсортированный массив.
     * @param array Массив.
     * @param from Индекс начала нового массива.
     * @param to Индекс конца нового массива.
     * @return Отсортированный массив.
     */
    private static int[] sort(int[] array, int from, int to) {
        if (from == to) {
            return new int[] {array[from]};
        }
        int mid = (from + to) / 2;
        return merge(
                sort(array, from, mid),
                sort(array, mid + 1, to)
        );
    }

    /**
     * Метод объединяет переданные два массива в один.
     * При объединении итоговый массив сортируется.
     * @param left Первый массив.
     * @param right Второй массив.
     * @return Отсортированный массив.
     */
    public static int[] merge(int[] left, int[] right) {
        int li = 0;
        int ri = 0;
        int resI = 0;
        int[] result = new int[left.length + right.length];
        while (resI != result.length) {
            if (li == left.length) {
                result[resI++] = right[ri++];
            } else if (ri == right.length) {
                result[resI++] = left[li++];
            } else if (left[li] < right[ri]) {
                result[resI++] = left[li++];
            } else {
                result[resI++] = right[ri++];
            }
        }
        return result;
    }

}
