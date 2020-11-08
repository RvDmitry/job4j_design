package ru.job4j.tictactoe;

/**
 * Class XOField
 * Класс характеризует игровое поле.
 * @author Dmitry Razumov
 * @version 1
 */
public class XOField implements Field {
    /**
     * Массив хранит значения ходов игроков.
     */
    private char[][] table;

    /**
     * Конструктор инициализирует массив.
     * @param table Массив.
     */
    public XOField(char[][] table) {
        this.table = table;
        init();
    }

    /**
     * Метод инициализиурет массив пробелами.
     * Для того, чтобы сформировать доску на экране с заданным размером. И в дальнейшем,
     * чтобы ее размер на экране не менялся, после того как будут добавляется ходы игроков.
     */
    private void init() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = ' ';
            }
        }
    }

    /**
     * Метод выводит игровое поле на экран.
     * Дополнительно нумеруя строки и стоблцы игрового поля.
     * Для того, чтобы игроку удобно было указывать номер клетки.
     */
    @Override
    public void printField() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("   " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(" " + table[i][j]);
                if (j + 1 != table[i].length) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i + 1 != table.length) {
                System.out.print("  ");
                for (int j = 0; j < table[i].length; j++) {
                    System.out.print("--- ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Метод проверяет, полность ли заполнено игровое поле.
     * @return true, если игровое поле заполнено полностью, иначе false.
     */
    @Override
    public boolean isFieldFull() {
        for (char[] chars : table) {
            for (char ch : chars) {
                if (ch == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
