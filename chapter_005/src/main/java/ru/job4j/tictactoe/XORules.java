package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**
 * Class XORules
 * Класс определяет победителя.
 * @author Dmitry Razumov
 * @version 1
 */
public class XORules implements Rules {
    /**
     * Массив хранит значения ходов игроков.
     */
    private char[][] table;

    /**
     * Конструктор инициализирует массив.
     * @param table Массив.
     */
    public XORules(char[][] table) {
        this.table = table;
    }

    /**
     * Метод проверяет, выиграли ли крестики.
     * @return true, если выиграли крестики, иначе false.
     */
    @Override
    public boolean checkWinX() {
        return isWinner(ch -> ch == 'X');
    }

    /**
     * Метод проверяет, выиграли ли нолики.
     * @return true, если выиграли нолики, иначе false.
     */
    @Override
    public boolean checkWinO() {
        return isWinner(ch -> ch == 'O');
    }

    /**
     * Метод проверяет, имеется ли выигрышная последовательность на доске.
     * @param predicate Условие, для крестиков либо ноликов.
     * @return true, если имеется выигрышная последовательность, иначе false.
     */
    private boolean isWinner(Predicate<Character> predicate) {
        for (int i = 0; i != table.length; i++) {
            if (this.fill(predicate, 0, i, 1, 0)
                    || this.fill(predicate, i, 0, 0, 1)) {
                return true;
            }
        }
        return this.fill(predicate, 0, 0, 1, 1)
                || this.fill(predicate, this.table.length - 1, 0, -1, 1);
    }

    /**
     * Метод проверяет, заполнена ли полностью строка либо столбец либо диагональ,
     * крестиками или ноликами.
     * @param predicate Условие, для крестиков либо ноликов.
     * @param startX Начальная строка.
     * @param startY Начальный столбец.
     * @param dX Смещение по строке.
     * @param dY Смещение по столбцу.
     * @return true, если строка либо столбец либо диагональ, заполнена полностью, иначе false.
     */
    private boolean fill(Predicate<Character> predicate, int startX, int startY, int dX, int dY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            char ch = this.table[startX][startY];
            startX += dX;
            startY += dY;
            if (!predicate.test(ch)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
