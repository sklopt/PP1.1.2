package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.DAOException;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DAOException {
        // version to Hibernate
        UserService userService = new UserServiceImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Для управления базой данных существуют следующие команды:
                1: Создать таблицу Users
                2: Удалить таблицу Users
                3: Очистить содержание таблицы Users
                4: Добавить новых User(ов) в таблицу Users
                5: Удалить User(а) из таблицы Users (по номеру id)
                6: Получить список всех User(ов) из таблицы Users
                7: Завершение работы программы

                Введите цифру, которая соответствует вашему выбору:"""
        );
        int command = sc.nextInt();
        while (command != 7) {
            if (command <= 0 || command > 7) {
                System.out.println("Введена неверная цифра.");
            }
            switch (command) {
                case 1 -> userService.createUsersTable();
                case 2 -> userService.dropUsersTable();
                case 3 -> userService.cleanUsersTable();
                case 4 -> {
                    System.out.println("Сколько записей необходимо добавить? Введите количество: ");
                    int count = sc.nextInt();
                    while (count != 0) {
                        if (count <= 0) {
                            System.out.println("Количество не может быть отрицательным или равным нулю. Введите положительное число: ");
                            count = sc.nextInt();
                        } else {
                            System.out.println("Для добавления новой записи введите имя, фамилию и возраст.\n" +
                                    "Введите имя:");
                            String name = sc.next();
                            System.out.println("Введите фамилию:");
                            String lastName = sc.next();
                            System.out.println("Введите возраст:");
                            byte age = sc.nextByte();
                            userService.saveUser(name, lastName, age);
                            System.out.println("User с именем - " + name + " добавлен в базу данных");
                            count--;
                        }
                    }
                }
                case 5 -> {
                    List<User> result = userService.getAllUsers();
                    for (User user : result) {
                        System.out.println(user);
                    }
                    System.out.println("\nВведите номер id для удаления записи:");
                    long id = sc.nextLong();
                    userService.removeUserById(id);
                }
                case 6 -> {
                    List<User> result = userService.getAllUsers();
                    for (User user : result) {
                        System.out.println(user);
                    }
                }
            }
            System.out.println();
            System.out.println("""
                    Для управления базой данных существуют следующие команды:
                    1: Создать таблицу Users
                    2: Удалить таблицу Users
                    3: Очистить содержание таблицы Users
                    4: Добавить новых User(ов) в таблицу Users
                    5: Удалить User(а) из таблицы Users (по номеру id)
                    6: Получить список всех User(ов) из таблицы Users
                    7: Завершение работы программы

                    Введите цифру, которая соответствует вашему выбору:"""
            );
            command = sc.nextInt();
        }
        System.out.println("Работа окончена");
    }
}

// version to JDBC
//        System.out.println("""
//                Для управления базой данных существуют следующие команды:
//                1: Создать таблицу Users
//                2: Удалить таблицу Users
//                3: Очистить содержание таблицы Users
//                4: Добавить новых User(ов) в таблицу Users
//                5: Удалить User(а) из таблицы Users (по номеру id)
//                6: Получить список всех User(ов) из таблицы Users
//                7: Завершение работы программы
//
//                Введите цифру, которая соответствует вашему выбору:"""
//        );
//        int command = sc.nextInt();
//        while (command != 7) {
//            if (command <= 0 || command > 7) {
//                System.out.println("Введена неверная цифра.");
//            }
//            switch (command) {
//                case 1 -> userService.createUsersTable();
//                case 2 -> userService.dropUsersTable();
//                case 3 -> userService.cleanUsersTable();
//                case 4 -> {
//                    System.out.println("Сколько записей необходимо добавить? Введите количество: ");
//                    int count = sc.nextInt();
//                    while (count != 0) {
//                        if (count <= 0) {
//                            System.out.println("Количество не может быть отрицательным или равным нулю. Введите положительное число: ");
//                            count = sc.nextInt();
//                        } else {
//                            System.out.println("Для добавления новой записи введите имя, фамилию и возраст.\n" +
//                                    "Введите имя:");
//                            String name = sc.next();
//                            System.out.println("Введите фамилию:");
//                            String lastName = sc.next();
//                            System.out.println("Введите возраст:");
//                            byte age = sc.nextByte();
//                            userService.saveUser(name, lastName, age);
//                            System.out.println("User с именем - " + name + " добавлен в базу данных");
//                            count--;
//                        }
//                    }
//                }
//                case 5 -> {
//                    userService.getAllUsers();
//                    System.out.println("\nВведите номер id для удаления записи:");
//                    long id = sc.nextLong();
//                    userService.removeUserById(id);
//                }
//                case 6 -> userService.getAllUsers();
//            }
//            System.out.println();
//            System.out.println("""
//                    Для управления базой данных существуют следующие команды:
//                    1: Создать таблицу Users
//                    2: Удалить таблицу Users
//                    3: Очистить содержание таблицы Users
//                    4: Добавить новых User(ов) в таблицу Users
//                    5: Удалить User(а) из таблицы Users (по номеру id)
//                    6: Получить список всех User(ов) из таблицы Users
//                    7: Завершение работы программы
//
//                    Введите цифру, которая соответствует вашему выбору:"""
//            );
//            command = sc.nextInt();
//        }
//        System.out.println("Работа окончена");


