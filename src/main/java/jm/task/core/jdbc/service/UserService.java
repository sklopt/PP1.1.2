package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.DAOException;
import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserService {
    void createUsersTable() throws DAOException;

    void dropUsersTable() throws DAOException;

    void saveUser(String name, String lastName, byte age) throws DAOException;

    void removeUserById(long id) throws DAOException;

    List<User> getAllUsers() throws DAOException;

    void cleanUsersTable() throws DAOException;
}
