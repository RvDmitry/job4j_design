package ru.job4j.multithreading.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorkingThreadTest {

    @Test
    public void whenWorking() throws InterruptedException {
        SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(5);
        for (int i = 0; i < 5; i++) {
            int num = i;
            Runnable task = () -> System.out.println("Task " + num);
            tasks.offer(task);
        }
        WorkingThread thread = new WorkingThread(tasks);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        assertTrue(tasks.isEmpty());
    }
}