package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoHibernateImpl table = new UserDaoHibernateImpl();
    public void createUsersTable() {
        table.createUsersTable();
    }

    public void dropUsersTable() {
        table.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        table.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        table.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return table.getAllUsers();
    }

    public void cleanUsersTable() {
        table.cleanUsersTable();
    }
}
