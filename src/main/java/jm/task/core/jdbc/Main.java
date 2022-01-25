package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Barak", "Obama", (byte) 77);
        userService.saveUser("Pikachu", "TheStorm", (byte) 12);
        userService.saveUser("Lyuban", "TheProgger", (byte) 23);
        userService.saveUser("Pushok", "Gribanov", (byte) 3);

        List<User> list = userService.getAllUsers();
        for (Object user : list
        ) {
            System.out.println(user.toString());
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
