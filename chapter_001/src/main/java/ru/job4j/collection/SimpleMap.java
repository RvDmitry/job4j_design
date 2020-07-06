package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleMap
 * Класс реализует коллекцию HashMap.
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleMap<K, V> implements Iterable<V> {
    /**
     * Массив для хранения значений карт.
     */
    private Node<K, V>[] table;
    /**
     * Параметр характеризует размер коллекции.
     */
    private int size;
    /**
     * Счетчик ведет подсчет количества модификаций коллекции.
     */
    private int modCount;
    /**
     * Параметр определяет коэффициент загрузки коллекции,
     * при достижении которого происходит увеличение размера коллекции.
     */
    private final double loadFactor = 0.75;

    /**
     * Конструктор инициализирует хеш-таблицу.
     */
    public SimpleMap() {
        table = new Node[16];
    }

    /**
     * Метод вставляет элемент в карту.
     * @param key Ключ
     * @param value Значение
     * @return true, если элемент встравлен успешно, иначе false
     */
    public boolean insert(K key, V value) {
        if (size == table.length * loadFactor) {
            resize();
        }
        int h = hash(key);
        int index = indexFor(h, table.length);
        if (table[index] == null) {
            table[index] = new Node<>(key, value);
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    /**
     * Метод возвращает значение элемента по его ключу.
     * @param key Ключ
     * @return Значение
     */
    public V get(K key) {
        int h = hash(key);
        int index = indexFor(h, table.length);
        var node = table[index];
        return node != null ? node.value : null;
    }

    /**
     * Метод удаляет элемент по его ключу.
     * @param key Ключ
     * @return true, если элемент вставлен успешно, иначе false
     */
    public boolean delete(K key) {
        int h = hash(key);
        int index = indexFor(h, table.length);
        if (table[index] != null) {
            table[index] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    /**
     * Метод вычисляет хеш-код ключа.
     * @param key Ключ
     * @return Хеш-код
     */
    private int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    /**
     * Метод определяет индекс ячейки массива, в которую будет помещатся элемент,
     * по хеш-коду ключа данного элемента.
     * @param h Хеш-код ключа
     * @param length Размер массива для хранения элементов
     * @return Индекс ячейки массива куда будет помещен элемент
     */
    private int indexFor(int h, int length) {
        return h & (length - 1);
    }

    /**
     * Метод увеличиват размер массива хранения элементов при достижении им определенного значения.
     */
    private void resize() {
        var oldTable = table;
        table = new Node[oldTable.length * 2];
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                int h = hash(oldTable[i].key);
                int index = indexFor(h, table.length);
                table[index] = oldTable[i];
            }
        }
    }

    /**
     * Класс определяет элемент карты.
     * @param <K> Тип ключа
     * @param <V> Тип значения
     */
    private static class Node<K, V> {
        /**
         * Ключ.
         */
        private final K key;
        /**
         * Значение.
         */
        private final V value;

        /**
         * Конструктор инициализирует элемент карты.
         * @param key Ключ
         * @param value Значение
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Метод возвращает итератор для обхода коллекции элементов.
     * @return Итератор
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<>() {
            private int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = point; i < table.length; i++) {
                    if (table[i] != null) {
                        point = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].value;
            }
        };
    }
}
