package ru.job4j.collection;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class Analize
 * Класс осуществляет анализ коллекции.
 * @author Dmitry Razumov
 * @version 1
 */
public class Analize {
    /**
     * Метод анализирует изменение коллекции и возвращает результат анализа в виде статистики.
     * @param previous Исходная коллекция
     * @param current Измененная коллекция
     * @return Статистика изменения коллекции
     */
    public Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        Map<Integer, User> first = previous.stream()
                .collect(Collectors.toMap(k -> k.id, user -> user));
        Map<Integer, User> second = current.stream()
                .collect(Collectors.toMap(k -> k.id, user -> user));
        for (int id : second.keySet()) {
            if (first.containsKey(id)) {
                if (!first.get(id).name.equals(second.get(id).name)) {
                    changed++;
                }
            } else {
                added++;
            }
        }
        for (int id : first.keySet()) {
            if (!second.containsKey(id)) {
                deleted++;
            }
        }
        return new Info(added, changed, deleted);
    }

    /**
     * Класс характеризует пользователя.
     */
    public static class User {
        /**
         * Уникальный номер пользователя.
         */
        private final int id;
        /**
         * Имя пользователя.
         */
        private final String name;

        /**
         * Конструктор создает пользователя.
         * @param id Уникальный номер
         * @param name Имя
         */
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        /**
         * Метод сравнивает двух пользователей на равенство.
         * @param o Объект - пользователь
         * @return true, если пользователь один и тот же, иначе false
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        /**
         * Метод вычисляет хеш-код пользователя.
         * @return Хеш-код
         */
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    /**
     * Класс содержит статистику характеризующую коллекцию пользователей.
     */
    public static class Info {
        /**
         * Количество добавленых пользователей.
         */
        private final int added;
        /**
         * Количество измененных пользователей.
         */
        private final int changed;
        /**
         * Количество удаленных пользователей.
         */
        private final int deleted;

        /**
         * Конструктор инициализирует данные статистики.
         * @param added Добавлено пользователей
         * @param changed Изменено пользователей
         * @param deleted Удалено пользователей
         */
        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        /**
         * Метод возвращает количество добавленных пользователей.
         * @return Число добавленных пользователей
         */
        public int getAdded() {
            return added;
        }

        /**
         * Метод возвращает количество измененных пользователей.
         * @return Число измененных пользователей
         */
        public int getChanged() {
            return changed;
        }

        /**
         * Метод возвращает количество удаленных пользователей.
         * @return Число удаленных пользователей
         */
        public int getDeleted() {
            return deleted;
        }
    }
}
