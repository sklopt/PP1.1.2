package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() throws SQLException {
        String SQLCreateUserTable = "CREATE TABLE IF NOT EXISTS users (Id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45) NOT NULL , lastName VARCHAR(65) NOT NULL , age TINYINT UNSIGNED NOT NULL)";
        Util util = new Util();
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQLCreateUserTable);
        }
    }

    public void dropUsersTable() throws SQLException {
        String SQLDropUsersTable = "DROP TABLE IF EXISTS users";
        Util util = new Util();
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQLDropUsersTable);
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String SQLSaveUser = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        Util util = new Util();
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLSaveUser)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
        }
    }

    public void removeUserById(long id) throws SQLException {
        String SQLRemoveUserById = "DELETE FROM users WHERE id = (?)";
        Util util = new Util();
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLRemoveUserById)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        String SQLGetAllUsers = "SELECT * FROM users";
        Util util = new Util();
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLGetAllUsers)) {
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
                System.out.println(user);
            }
            return userList;
        }
    }

    public void cleanUsersTable() throws SQLException {
        String SQLCleanUsersTable = "TRUNCATE TABLE users";
        Util util = new Util();
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQLCleanUsersTable);
        }
    }
}
