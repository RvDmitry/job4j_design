package ru.job4j.spammer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Class ImportDB
 * Класс осуществляет запись в БД данные их текстового файла.
 * @author Dmitry Razumov
 * @version 1
 */
public class ImportDB {
    /**
     * В поле создается логгер для вывода сообщений.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ImportDB.class);
    /**
     * Поле содержит настройки подключения к БД.
     */
    private final Properties cfg;
    /**
     * Путь к файлу с данными, которые нужно вычитать из файла.
     */
    private final String dump;

    /**
     * Конструктор инициализирует данные.
     * @param cfg Конфигурация для подключения к БД
     * @param dump Файл с данными
     */
    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    /**
     * Метод загружает информацию о пользователях из файла.
     * @return Список содержащий данные пользователей
     * @throws IOException Исключение, возникает при ошибке доступа к файлу
     */
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .forEach(s -> users.add(new User(s.split(";")[0], s.split(";")[1])));
        }
        LOG.info("Чтение файла пользователей прошло успешно.");
        return users;
    }

    /**
     * Метод сохраняет данные пользователей в БД.
     * @param users Список пользователей
     * @throws ClassNotFoundException Исключение, если драйвер не может быть загружен
     * @throws SQLException Исключение, если есть ошибки при взаимодействии с БД
     */
    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement(
                        "insert into users(name, email) values(?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
        LOG.info("Запись данных в БД прошла успешно.");
    }

    /**
     * Класс описывает характеристики пользователя.
     */
    private static class User {
        /**
         * Имя пользователя.
         */
        private final String name;
        /**
         * e-mail пользователя.
         */
        private final String email;

        /**
         * Конструтор инициализирует данные пользователя.
         * @param name Имя
         * @param email e-mail
         */
        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    /**
     * Главный метод программы. Запускает программу.
     * @param args Параметры командной строки
     * @throws Exception Исключение, при ошибках доступа к файлу либо к БД
     */
    public static void main(String[] args) throws Exception {
        String properties = "chapter_003/src/main/resources/app.properties";
        String dump = "chapter_003/src/main/resources/dump.txt";
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream(properties)) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, dump);
        db.save(db.load());
    }
}
