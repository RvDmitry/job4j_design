package ru.job4j.storage;

import net.jcip.annotations.ThreadSafe;

import java.util.*;
import java.util.function.Predicate;

/**
 * Class UserStore
 * Класс реализует хранилище пользователей.
 * @author Dmitry Razumov
 * @version 1
 */
@ThreadSafe
public class UserStore implements Store, Transfer {
    /**
     * Поле содержит хранилище пользователей.
     */
    private final Map<Integer, User> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в хранилище, если пользователя в хранилище нет.
     * @param user Пользователь.
     * @return true, если пользователь добавлен успешно, иначе false.
     */
    @Override
    public synchronized boolean add(User user) {
        return action(user, Objects::nonNull);
    }

    /**
     * Метод обновляет пользователя в хранилище, если данный пользователь в хранилище имеется.
     * @param user Пользователь.
     * @return true, если пользователь обновлен успешно, иначе false.
     */
    @Override
    public synchronized boolean update(User user) {
        return action(user, Objects::isNull);
    }

    /**
     * Метод удаляет пользователя из хранилища.
     * @param user Пользователь.
     * @return true, если пользователь удален успешно, иначе false.
     */
    @Override
    public synchronized boolean delete(User user) {
        User u = users.remove(user.getId());
        return u != null;
    }

    /**
     * Метод осуществляет передачу денег со счета одного пользователя на счет другого.
     * @param fromId ID пользователя, от которого осуществляется передача денег.
     * @param toId ID пользователя, которому осуществляется передача денег.
     * @param amount Сумма денег, которую нужно передать.
     * @return true, если передача прошла успешно, иначе false.
     */
    @Override
    public synchronized boolean transfer(int fromId, int toId, int amount) {
        User first = users.get(fromId);
        User second = users.get(toId);
        if (first == null || second == null) {
            return false;
        }
        if (first.getAmount() < amount) {
            return false;
        }
        first.setAmount(first.getAmount() - amount);
        second.setAmount(second.getAmount() + amount);
        return true;
    }

    /**
     * Метод добавляет или обновляет пользователя в хранилище.
     * @param user Пользователь.
     * @param pre Условие
     * @return true, если добавление или обновление прошло успешно, иначе false.
     */
    private boolean action(User user, Predicate<User> pre) {
        User u = users.get(user.getId());
        if (pre.test(u)) {
            return false;
        }
        users.put(user.getId(), user);
        return true;
    }
}
