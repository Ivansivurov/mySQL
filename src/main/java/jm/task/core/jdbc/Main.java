package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl table = new UserServiceImpl();
        table.createUsersTable();

        table.saveUser("Barak", "Obama", (byte) 77);
        table.saveUser("Pikachu", "TheStorm", (byte) 12);
        table.saveUser("Lyuban", "TheProgger", (byte) 23);
        table.saveUser("Pushok", "Gribanov", (byte) 3);

        List<User> list = table.getAllUsers();
        for (Object user : list
        ) {
            System.out.println(user.toString());
        }

        table.cleanUsersTable();
        table.dropUsersTable();
    }
}
