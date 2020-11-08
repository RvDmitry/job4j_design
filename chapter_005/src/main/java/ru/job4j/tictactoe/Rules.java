package ru.job4j.tictactoe;

/**
 * Interface Rules
 * Интерфейс определяет методы проверяющие выигрышную последовательность.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Rules {
    /**
     * Метод проверяет, имеется ли выигрышная комбинация для крестиков.
     * @return true, если комбинация есть, иначе false.
     */
    boolean checkWinX();

    /**
     * Метод проверяет, имеется ли выигрышная комбинация для ноликов.
     * @return true, если комбинация есть, иначе false.
     */
    boolean checkWinO();
}
