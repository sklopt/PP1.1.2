package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.DAOException;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    // version to JDBC
//    UserDao userDao = new UserDaoJDBCImpl();
    // version to Hibernate
    UserDao userDao = new UserDaoHibernateImpl();

    public void createUsersTable() throws DAOException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws DAOException {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws DAOException {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws DAOException {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() throws DAOException {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() throws DAOException {
        userDao.cleanUsersTable();
    }
}
