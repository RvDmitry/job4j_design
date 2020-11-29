package ru.job4j.multithreading.pools;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class ThreadPoolTest
 * Класс тестирует пул потоков.
 * @author Dmitry Razumov
 * @version 1
 */
public class ThreadPoolTest {

    @Test
    public void whenThreadPoolWorking() throws InterruptedException {
        CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        ThreadPool threadPool = new ThreadPool(10, 2);
        for (int i = 0; i < 10; i++) {
            int task = i;
            threadPool.work(() -> {
                buffer.add(task);
            });
        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.shutdown();
        buffer.sort(Integer::compareTo);
        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }
}