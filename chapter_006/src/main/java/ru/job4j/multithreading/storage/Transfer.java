package ru.job4j.multithreading.storage;

/**
 * Interface Transfer
 * Интерфейс определяет метод передачи денег от одного пользователя другому.
 * @author Dmitry Razumov
 * @version 1
 */
public interface Transfer {
    /**
     * Метод осуществляет передачу денег со счета одного пользователя на счет другого.
     * @param fromId ID пользователя, от которого осуществляется передача денег.
     * @param toId ID пользователя, которому осуществляется передача денег.
     * @param amount Сумма денег, которую нужно передать.
     * @return true, если передача прошла успешно, иначе false.
     */
    boolean transfer(int fromId, int toId, int amount);
}
