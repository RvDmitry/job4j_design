package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class UsageLog4j
 * В классе демонстрируется использование логгирования.
 * @author Dmitry Razumov
 * @version 1
 */
public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    /**
     * Главный метод программы.
     * @param args Параметры командной строки
     */
    public static void main(String[] args) {
        String name = "Petr Petrov";
        byte age = 35;
        boolean isOpen = true;
        short zip = 15236;
        int account = 4561239;
        long bank = 456897135456L;
        float percent = 5.6f;
        double money = 12346.12;
        char code = 'A';
        LOG.debug("User info name : {}, age : {}, isOpen : {}, zip : {}, account : {}, "
                + "bank : {}, percent : {}, money : {}, code : {}", name, age, isOpen, zip,
                account, bank, percent, money, code);
        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
