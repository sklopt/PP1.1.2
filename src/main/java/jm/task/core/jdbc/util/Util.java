package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@SuppressWarnings("FieldCanBeLocal")
public class Util {
    private final String HOSTNAME = "localhost";
    private final String DBNAME = "draftPPDB";
    private final String USERNAME = "root";
    private final String PASSWORD = "3305";
    private final String CONNECTIONURL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DBNAME;
    private static Connection connection;
    public Util() {
        try {
            connection = DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
