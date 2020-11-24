package ru.job4j.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class SimpleBlockingQueue
 * Класс тестирует блокирующую очередь.
 * @author Dmitry Razumov
 * @version 1
 */
public class SimpleBlockingQueueTest {

    @Test
    public void whenQueueRun() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.offer(i);
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.poll();
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        assertTrue(queue.isEmpty());
    }
}