package ru.job4j.it;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter
 * Класс конвертирует итератор итераторов в итератор.
 * @author Dmitry Razumov
 * @version 1
 */
public class Converter {
    /**
     * Метод конвертирует итератор итераторов чисел в итератор чисел.
     * @param it Итератор итераторов чисел
     * @return Итератор чисел
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> iter = Collections.emptyIterator();

            @Override
            public boolean hasNext() {
                while (it.hasNext() && !iter.hasNext()) {
                    iter = it.next();
                }
                return iter.hasNext();
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return iter.next();
            }
        };
    }
}
