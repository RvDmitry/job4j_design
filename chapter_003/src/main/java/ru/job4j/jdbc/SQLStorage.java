package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Class SQLStorage
 * В классе практикуется работа с базой данных.
 * @author Dmitry Razumov
 * @version 1
 */
public class SQLStorage {
    private static final Logger LOG = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
        String username = "postgres";
        String password = "postgres";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement(
                    "select * from users where id in (?, ?, ?)"
            );
            st.setInt(1, 2);
            st.setInt(2, 5);
            st.setInt(3, 7);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(
                        String.format("%s %s",
                                rs.getString("login"),
                                rs.getTimestamp("create_date"))
                );
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
}
