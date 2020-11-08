package ru.job4j.tictactoe;

/**
 * Class TicTacToe
 * Класс запускает игру крестики-нолики.
 * @author Dmitry Razumov
 * @version 1
 */
public class TicTacToe {
    /**
     * Метод запускает игры крестики-нолики.
     * @param field Объект характеризует игровое поле.
     * @param player Объект характеризует игроков.
     * @param rules Объект определяет победителя.
     */
    public void start(Field field, Player player, Rules rules) {
        field.printField();
        while (true) {
            player.turnHuman();
            if (rules.checkWinX()) {
                System.out.println("Победили крестики.");
                break;
            }
            if (field.isFieldFull()) {
                System.out.println("Ничья.");
                break;
            }
            field.printField();
            player.turnAI();
            if (rules.checkWinO()) {
                System.out.println("Победили нолики.");
                break;
            }
            if (field.isFieldFull()) {
                System.out.println("Ничья.");
                break;
            }
            field.printField();
        }
        field.printField();
    }

    /**
     * Главный метод программы.
     * @param args Параметры командной строки.
     */
    public static void main(String[] args) {
        char[][] table = new char[3][3];
        XOField field = new XOField(table);
        XOPlayer player = new XOPlayer(table);
        XORules rules = new XORules(table);
        new TicTacToe().start(field, player, rules);
    }
}
