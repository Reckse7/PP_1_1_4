package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        List<User> list;
        UserService service = new UserServiceImpl();
        service.createUsersTable();

        for (int i = 0; i < 4; i++) {
            service.saveUser(String.valueOf(i), "user", (byte) 18);
            System.out.printf("Юзер с именем - %s добавлен в базу данных\n", i);
        }

        list = service.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }

        service.cleanUsersTable();
        service.dropUsersTable();
    }
}
