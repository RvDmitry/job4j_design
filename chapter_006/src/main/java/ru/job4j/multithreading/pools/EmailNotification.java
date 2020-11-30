package ru.job4j.multithreading.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Class EmailNotification
 * Класс реализует сервис рассылки почты.
 * @author Dmitry Razumov
 * @version 1
 */
public class EmailNotification {

    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void emailTo(User user) {
        String subject = String.format("Notification %s to email %s.",
                user.getUsername(), user.getEmail());
        String body = String.format("Add a new event to %s", user.getUsername());
        pool.execute(() -> {
            send(subject, body, user.getEmail());
        });
    }

    public void close() throws InterruptedException {
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
    }

    public void send(String suject, String body, String email) {

    }
}
