package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@SuppressWarnings("FieldCanBeLocal")
public class Util {
    private static final String HOSTNAME = "localhost";
    private static final String DBNAME = "draftPPDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "3305";
    private static final String CONNECTION_URL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DBNAME;
    private static Connection connection;
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return connection;
    }
}
