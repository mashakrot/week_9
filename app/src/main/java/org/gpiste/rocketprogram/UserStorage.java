package org.gpiste.rocketprogram;

import java.util.ArrayList;

public class UserStorage {

    private ArrayList<User> users;
    private static UserStorage instance;
    private UserStorage() {
        users = new ArrayList<>();
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void listUser() {
        int i = 0;
        for (User user : users) {
            System.out.println(i++ + ": " + user.getFirstName() + " " + user.getLastName());
        }
    }


}