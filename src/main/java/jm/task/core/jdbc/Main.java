package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Barak", "Obama", (byte) 77);
        userDaoHibernate.saveUser("Pikachu", "TheStorm", (byte) 12);
        userDaoHibernate.saveUser("Lyuban", "TheProgger", (byte) 23);
        userDaoHibernate.saveUser("Pushok", "Gribanov", (byte) 3);
        List<User> list = userDaoHibernate.getAllUsers();
        for (Object user : list
        ) {
            System.out.println(user.toString());
        }
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();
    }
}
