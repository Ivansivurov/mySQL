package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String SQL = "CREATE TABLE IF NOT EXISTS users " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(50), " +
                    " lastName VARCHAR (50), " +
                    " age INTEGER (255), " +
                    " PRIMARY KEY (id))";
            session.createSQLQuery(SQL).executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list;
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            list = session.createQuery("FROM User").list();
            transaction.commit();
        }
        return list;
    }
    @Override
    public void cleanUsersTable() {
        try(Session session = Util.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DELETE FROM users").executeUpdate();
            transaction.commit();
        }
    }
}
